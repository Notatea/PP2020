package com.menu;

import com.CustomScanner;
import com.сore.models.Sweets;
import com.сore.services.Data;
import com.сore.services.SweetsCreator;

public class CreateSweetsCommand implements MenuItem {
    @Override
    public void execute() {
        System.out.println("\n\n\tSweets creating");
        Sweets sweets = SweetsCreator.createSweets();
        if (sweets == null) {
            return;
        }
        Data.addSweets(sweets);
        CustomScanner.delay();
    }
}
