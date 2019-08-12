package com.epam.rd.spring2019.pet.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Product implements Serializable {

    private static final long serialVersionUID = 5331875485776907085L;

    private Long id;
    private String name;
    private String description;
    private String image;
    private Double weight;
    private Double volume;
    private Double price;
    private LocalDate created;
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", price=" + price +
                ", created=" + created +
                '}';
    }

    public static class Builder {
        private final Product newProduct;

        public Builder() {
            newProduct = new Product();
        }

        public Product.Builder setId(Long id) {
            newProduct.id = id;

            return this;
        }

        public Product.Builder setName(String name) {
            newProduct.name = name;

            return this;
        }

        public Product.Builder setDescription(String description) {
            newProduct.description = description;

            return this;
        }

        public Product.Builder setImage(String image) {
            newProduct.image = image;

            return this;
        }

        public Product.Builder setWeight(Double weight) {
            newProduct.weight = weight;

            return this;
        }

        public Product.Builder setVolume(Double volume) {
            newProduct.volume = volume;

            return this;
        }

        public Product.Builder setPrice(Double price) {
            newProduct.price = price;

            return this;
        }

        public Product.Builder setCreated(LocalDate created) {
            newProduct.created = created;

            return this;
        }

        public Product.Builder setCategory(Category category) {
            newProduct.category = category;

            return this;
        }

        public Product build() {
            return newProduct;
        }

    }
}
