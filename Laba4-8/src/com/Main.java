package com;

import com.menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();

        while (true) {
            System.out.println(mainMenu);
            int choice = CustomScanner.getChoice(1, 9);
            mainMenu.execute(choice);
            CustomScanner.delay();
        }
    }
}
