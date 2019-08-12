package com.epam.rd.spring2019.pet.web.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FilterProductDto implements Serializable {

    private static final long serialVersionUID = 1969875805679832017L;

    private String minPrice;
    private String maxPrice;
    private String productName;
    private List<String> categoriesId = new ArrayList<>();

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(List<String> categoriesId) {
        this.categoriesId = categoriesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterProductDto that = (FilterProductDto) o;

        if (getMinPrice() != null ? !getMinPrice().equals(that.getMinPrice()) : that.getMinPrice() != null)
            return false;
        if (getMaxPrice() != null ? !getMaxPrice().equals(that.getMaxPrice()) : that.getMaxPrice() != null)
            return false;
        if (getProductName() != null ? !getProductName().equals(that.getProductName()) : that.getProductName() != null)
            return false;
        return getCategoriesId() != null ? getCategoriesId().equals(that.getCategoriesId()) : that.getCategoriesId() == null;
    }

    @Override
    public int hashCode() {
        int result = getMinPrice() != null ? getMinPrice().hashCode() : 0;
        result = 31 * result + (getMaxPrice() != null ? getMaxPrice().hashCode() : 0);
        result = 31 * result + (getProductName() != null ? getProductName().hashCode() : 0);
        result = 31 * result + (getCategoriesId() != null ? getCategoriesId().hashCode() : 0);
        return result;
    }
}
