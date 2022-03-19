package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends Item {

    public Drink(String itemSlot, String name, BigDecimal price, String itemType) {
        super(itemSlot, name, price, itemType);
    }

    @Override
    public String getSound() {
        return "Glug Glug, Yum!";
    }

}
