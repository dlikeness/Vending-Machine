package com.techelevator.view;

import java.math.BigDecimal;

public class Chip extends Item {

    public Chip(String itemSlot, String name, BigDecimal price, String itemType) {
        super(itemSlot, name, price, itemType);
    }

    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }

}
