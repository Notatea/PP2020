package com.menu;

import com.CustomScanner;
import com.сore.services.Data;

public class ChangeGiftCommand implements MenuItem {
    @Override
    public void execute() {
        System.out.println("\n\n\tGift changing");
        Data.changeGift();
        CustomScanner.delay();
    }
}
