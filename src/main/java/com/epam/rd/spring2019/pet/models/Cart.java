package com.epam.rd.spring2019.pet.models;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String,TradeUnit> tradeUnitMap;
    private Double total;
    private Integer quantity;

    public Cart() {
        total = 0.0;
        quantity = 0;
        tradeUnitMap = new HashMap<>();
    }

    public Map<String, TradeUnit> getTradeUnitMap() {
        return tradeUnitMap;
    }

    public void setTradeUnitMap(Map<String, TradeUnit> tradeUnitMap) {
        this.tradeUnitMap = tradeUnitMap;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void calculateAmount() {
        total = 0.0;
        quantity = 0;
        for (TradeUnit unit: tradeUnitMap.values()) {
            quantity += unit.getQuantity();
            total += unit.getPrice() * unit.getQuantity();
        }
    }

    public String getTotalFormat() {
        return new DecimalFormat("###,##0.00").format(total);
    }

}
