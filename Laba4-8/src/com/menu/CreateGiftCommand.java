package com.menu;

import com.CustomScanner;
import com.сore.services.Data;

public class CreateGiftCommand implements MenuItem {
    @Override
    public void execute() {
        System.out.println("\n\n\tGift creating");
        Data.createGift();
        CustomScanner.delay();
    }
}