package com.menu;

import com.CustomScanner;
import com.сore.services.Data;

public class PrintCreatedSweetsCommand implements MenuItem{
    @Override
    public void execute() {
        Data.printCreatedSweets();
        CustomScanner.delay();
    }
}
