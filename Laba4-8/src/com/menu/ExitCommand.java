package com.menu;

public class ExitCommand implements MenuItem{
    @Override
    public void execute() {
        System.out.println("\nExiting...");
        System.exit(0);
    }
}
