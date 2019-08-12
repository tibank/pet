package com.epam.rd.spring2019.pet.daos;

import com.epam.rd.spring2019.pet.Utils.UtilsDao;
import com.epam.rd.spring2019.pet.config.DBManager;
import com.epam.rd.spring2019.pet.config.PropertiesManager;
import com.epam.rd.spring2019.pet.exceptions.ApplicationException;
import com.epam.rd.spring2019.pet.models.Product;
import com.epam.rd.spring2019.pet.web.dtos.FilterProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private PropertiesManager propertiesManager = new PropertiesManager();

    private final static Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);
    private CategoryDao categoryDao = new CategoryDaoImpl();

    private static final String PRODUCT_INSERT_QUERY =
            "INSERT products(name, description, image, weight, volume, price, category_id, created)" +
                    "VALUES (?,?,?,?,?,?,?,curdate())";

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        try (Connection conn = DBManager.getDBConnection();
             PreparedStatement st = conn.prepareStatement("SELECT * FROM products")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                productList.add(getProductFromResultSet(rs));
            }
        } catch (SQLException e) {
            log.error("SQL Error get all categories " + UtilsDao.getSQLErrorString(e));
            throw new ApplicationException("SQL Error get all categories " + UtilsDao.getSQLErrorString(e), e);
        } catch (NamingException e) {
            log.error("Failed to connect to DB");
            throw new ApplicationException("Failed to connect to DB", e);
        }
        return productList;
    }

    @Override
    public Product getProductById(Long id) {
        Product product = null;
        try (Connection conn = DBManager.getDBConnection();
             PreparedStatement st = conn.prepareStatement("SELECT * FROM products WHERE id = ?")) {
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                product = getProductFromResultSet(rs);
            }
        } catch (SQLException e) {
            log.error("SQL Error get all categories " + UtilsDao.getSQLErrorString(e));
            throw new ApplicationException("SQL Error get all categories " + UtilsDao.getSQLErrorString(e), e);
        } catch (NamingException e) {
            log.error("Failed to connect to DB");
            throw new ApplicationException("Failed to connect to DB", e);
        }
        return product;
    }

    @Override
    public Product addProduct(Product product) {
        try (Connection conn = DBManager.getDBConnection();
             //try (Connection conn = DBManager.getConnection(propertiesManager.getApplicationProperties());
             PreparedStatement st = conn.prepareStatement(PRODUCT_INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, product.getName());
            st.setString(2, product.getDescription());
            st.setString(3, product.getImage());
            st.setDouble(4, product.getWeight());
            st.setDouble(5, product.getVolume());
            st.setDouble(6, product.getPrice());
            st.setInt(7, product.getCategory().getId());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                product.setId(rs.getLong(1));
            }
        } catch (SQLException ex) {
            log.error("SQL Error add new user " + UtilsDao.getSQLErrorString(ex));
            throw new ApplicationException("Failed to insert new product into DB", ex);
        } catch (NamingException ex) {
            log.error("Failed to connect to DB " + ex);
            throw new ApplicationException("Failed to connect to DB", ex);
        }

        return product;
    }

    @Override
    public List<Product> getProductsByFilter(FilterProductDto filter) {
        List<Product> productList = new ArrayList<>();

        String quyreFilter = "SELECT * FROM products";

        String queryConditionPrice = getConditionByPrice(filter);
        if (!queryConditionPrice.isEmpty()) {
            quyreFilter = quyreFilter.concat(" WHERE ").concat(queryConditionPrice);
        }

        String queryConditionCategory = getConditionByCategories(filter);
        if (!queryConditionCategory.isEmpty()) {
            if (!queryConditionPrice.isEmpty()) {
                quyreFilter = quyreFilter.concat(" AND ");
            } else {
                quyreFilter = quyreFilter.concat(" WHERE ");
            }
            quyreFilter = quyreFilter.concat(queryConditionCategory);
        }

        int countParamsQuery = 0;
        try (Connection conn = DBManager.getDBConnection();
             PreparedStatement st = conn.prepareStatement(quyreFilter)) {

            if (filter.getMinPrice() != null) {
                if (Integer.valueOf(filter.getMinPrice()) > 0) {
                    countParamsQuery++;
                    st.setInt(countParamsQuery, Integer.valueOf(filter.getMinPrice()));
                }
            }

            if (filter.getMaxPrice() != null) {
                if (Integer.valueOf(filter.getMaxPrice()) > 0) {
                    countParamsQuery++;
                    st.setInt(countParamsQuery, Integer.valueOf(filter.getMaxPrice()));
                }
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                productList.add(getProductFromResultSet(rs));
            }
        } catch (SQLException e) {
            log.error("SQL Error get all categories " + UtilsDao.getSQLErrorString(e));
            throw new ApplicationException("SQL Error get all categories " + UtilsDao.getSQLErrorString(e), e);
        } catch (NamingException e) {
            log.error("Failed to connect to DB");
            throw new ApplicationException("Failed to connect to DB", e);
        }
        return productList;
    }

    private String getConditionByPrice(FilterProductDto filter) {
        String result = "";

        if (filter.getMinPrice() != null) {
            if (Integer.valueOf(filter.getMinPrice()) > 0) {
                result += " price >= ?";
            }
        }

        if (filter.getMaxPrice() != null) {
            if (Integer.valueOf(filter.getMaxPrice()) > 0) {
                if (!result.isEmpty()) {
                    result += " AND ";
                }

                result += " price <= ?";
            }
        }


        return result;
    }

    private String getConditionByCategories(FilterProductDto filter) {
        StringBuilder result = new StringBuilder();
        List<String> categoriesId = filter.getCategoriesId();

        if (categoriesId.size() > 0) {
            result.append("category_id IN (");

            for (int i = 0; i < categoriesId.size() - 1; i++) {
                result.append(categoriesId.get(i)).append(",");
            }

            result.append(categoriesId.get(categoriesId.size() - 1)).append(")");
        }

        return result.toString();
    }

    private Product getProductFromResultSet(ResultSet rs) throws SQLException {
        return new Product.Builder()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setDescription(rs.getString("description"))
                .setImage(rs.getString("image"))
                .setWeight(rs.getDouble("weight"))
                .setVolume(rs.getDouble("volume"))
                .setPrice(rs.getDouble("price"))
                .setCategory(categoryDao.getCategoryById(rs.getInt("category_id")))
                .build();

    }

}
