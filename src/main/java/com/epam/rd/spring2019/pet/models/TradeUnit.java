package com.epam.rd.spring2019.pet.models;

import com.epam.rd.spring2019.pet.web.dtos.ProductViewDto;

import java.io.Serializable;
import java.util.Objects;

public class TradeUnit implements Serializable {

    private static final long serialVersionUID = -2366835545842031230L;

    private ProductViewDto product;
    private Integer quantity;
    private Double price;

    public TradeUnit(ProductViewDto product, Integer quantity, Double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductViewDto getProduct() {
        return product;
    }

    public void setProduct(ProductViewDto product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeUnit tradeUnit = (TradeUnit) o;
        return Objects.equals(product, tradeUnit.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(product);
    }

    @Override
    public String toString() {
        return "TradeUnit{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
