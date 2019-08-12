package com.epam.rd.spring2019.pet.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Order implements Serializable {

    private Long id;
    private String numberOrder;
    private LocalDate dateOrder;
    private User user;
    private TradeUnit details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(String numberOrder) {
        this.numberOrder = numberOrder;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TradeUnit getDetails() {
        return details;
    }

    public void setDetails(TradeUnit details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
