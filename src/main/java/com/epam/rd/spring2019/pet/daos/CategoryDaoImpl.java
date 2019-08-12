package com.epam.rd.spring2019.pet.daos;

import com.epam.rd.spring2019.pet.Utils.UtilsDao;
import com.epam.rd.spring2019.pet.config.DBManager;
import com.epam.rd.spring2019.pet.exceptions.ApplicationException;
import com.epam.rd.spring2019.pet.models.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private final static Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);
    private static final String CATEGORY_BY_ID_QUERY = "SELECT * FROM categories WHERE id = ?";
    private static final String GET_ALL_CATEGORIES_QUERY = "SELECT * FROM categories";

    @Override
    public Category getCategoryById(Integer id) {
        Category category = null;
        try (Connection conn = DBManager.getDBConnection();
             PreparedStatement st = conn.prepareStatement(CATEGORY_BY_ID_QUERY)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                category = new Category(rs.getInt("id"),
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            log.error("SQL Error get category by id " + UtilsDao.getSQLErrorString(e));
            throw new ApplicationException("SQL Error get category by id " + UtilsDao.getSQLErrorString(e),e);
        } catch (NamingException e) {
            log.error("Failed to connect to DB");
            throw new ApplicationException("Failed to connect to DB",e);
        }

        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();

        try (Connection conn = DBManager.getDBConnection();
             PreparedStatement st = conn.prepareStatement(GET_ALL_CATEGORIES_QUERY)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                categoryList.add(new Category(rs.getInt("id"),
                        rs.getString("name")));
            }
        } catch (SQLException e) {
            log.error("SQL Error get all categories " + UtilsDao.getSQLErrorString(e));
            throw new ApplicationException("SQL Error get all categories " + UtilsDao.getSQLErrorString(e),e);
        } catch (NamingException e) {
            log.error("Failed to connect to DB");
            throw new ApplicationException("Failed to connect to DB",e);
        }
        return categoryList;
    }
}
