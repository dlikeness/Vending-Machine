package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Item {

    private String itemSlot;
    private String name;
    private BigDecimal price;
    private String itemType;
    private int quantity = 5;

    public String getItemSlot() {
        return itemSlot;
    }

    public void setItemSlot(String itemSlot) {
        this.itemSlot = itemSlot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item() {
    }

    public Item(String itemSlot, String name, BigDecimal price, String itemType) {
            this.itemSlot = itemSlot;
            this.name = name;
            this.price = price;
            this.itemType = itemType;
        }

        //    Method
        public abstract String getSound ();

}