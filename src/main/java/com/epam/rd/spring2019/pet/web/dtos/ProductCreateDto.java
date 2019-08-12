package com.epam.rd.spring2019.pet.web.dtos;


import java.io.Serializable;
import java.util.Map;

public class ProductCreateDto implements Serializable {

    private static final long serialVersionUID = -132274832509995739L;

    private String name;
    private String description;
    private String image;
    private Double weight;
    private Double volume;
    private Double price;
    private Integer categoryId;

    public ProductCreateDto(Map<String,String> params) {
        this.name = params.get("name");
        this.description = params.get("description");
        this.image = params.get("image");

        String strWeight = params.get("weight");
        this.weight = strWeight != null && !strWeight.isEmpty() ? Double.valueOf(strWeight) : null;

        String strVolume = params.get("volume");
        this.volume = strVolume != null && !strVolume.isEmpty() ? Double.valueOf(strVolume) : null;

        String strPrice = params.get("price");
        this.price = strPrice != null && !strPrice.isEmpty() ? Double.valueOf(strPrice) : null;

        String strCategoryId = params.get("categoryId");
        this.categoryId = strCategoryId != null && !strCategoryId.isEmpty() ? Integer.valueOf(strCategoryId) : null;
        //this.categoryId = 1;
//        String strCategoryId = params.get("categoryid");
//        this.categoryId = strCategoryId != null && !strCategoryId.isEmpty() ? Integer.valueOf(strCategoryId) : null;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCreateDto that = (ProductCreateDto) o;

        if (!name.equals(that.name)) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (!weight.equals(that.weight)) return false;
        if (!volume.equals(that.volume)) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return categoryId.equals(that.categoryId);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + weight.hashCode();
        result = 31 * result + volume.hashCode();
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + categoryId.hashCode();
        return result;
    }
}
