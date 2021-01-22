package com.menu;

import com.CustomScanner;
import com.сore.services.Data;

public class ChangeSweetsCommand implements MenuItem {
    @Override
    public void execute() {
        System.out.println("\n\n\tSweets changing");
        Data.changeSweets();
        CustomScanner.delay();
    }
}