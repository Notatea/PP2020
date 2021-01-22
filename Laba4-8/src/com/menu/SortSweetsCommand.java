package com.menu;

import com.CustomScanner;
import com.сore.services.Data;

public class SortSweetsCommand implements MenuItem {
    @Override
    public void execute() {
        System.out.println("\n\n\tSweets sorting");
        Data.sortSweetsInTheGift();
        CustomScanner.delay();
    }
}