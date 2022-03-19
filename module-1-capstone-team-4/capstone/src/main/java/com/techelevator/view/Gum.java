package com.techelevator.view;

import java.math.BigDecimal;

public class Gum extends Item {

    public Gum(String itemSlot, String name, BigDecimal price, String itemType) {
        super(itemSlot, name, price, itemType);
    }
    @Override
    public String getSound() {
        return "Chew Chew, Yum!";
    }
}
