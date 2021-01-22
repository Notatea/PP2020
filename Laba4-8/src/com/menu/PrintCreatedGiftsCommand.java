package com.menu;

import com.CustomScanner;
import com.сore.services.Data;

public class PrintCreatedGiftsCommand implements MenuItem {
    @Override
    public void execute() {
        Data.printCreatedGifts();
        CustomScanner.delay();
    }
}
