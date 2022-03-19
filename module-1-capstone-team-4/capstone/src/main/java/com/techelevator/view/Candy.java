package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends Item {

    public Candy(String itemSlot, String name, BigDecimal price, String itemType) {
        super(itemSlot, name, price, itemType);
    }

    @Override
    public String getSound() {
        return "Munch Munch, Yum!";
    }


}
