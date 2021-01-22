package com.menu;

import com.CustomScanner;
import com.сore.services.Data;

public class FindSweetsCommand implements MenuItem {
    @Override
    public void execute() {
        System.out.println("\n\n\tSweets searching");
        Data.findSweetsInTheGift();
        CustomScanner.delay();
    }
}