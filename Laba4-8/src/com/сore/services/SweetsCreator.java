package com.сore.services;

import com.CustomScanner;
import com.сore.models.Candy;
import com.сore.models.Cookies;
import com.сore.models.Sweets;

public class SweetsCreator {
    private static String name;
    private static double weight;
    private static double sugarContent;

    public static Sweets createSweets() {
        printMenu();
        int choice = CustomScanner.getChoice(0, 2);
        if (choice == 0) {
            return null;
        }
        return choice == 1 ? createCandy() : createCookies();
    }

    private static void printMenu() {
        System.out.println("What sweets do you want to create?");
        System.out.println("1. Candy");
        System.out.println("2. Cookies");
        System.out.println("0. Return to main menu");
    }

    private static void getCommonFields() {
        CustomScanner.delay();
        System.out.print("Enter name: ");
        name = CustomScanner.getScanner().nextLine();
        System.out.print("Enter weight: ");
        weight = CustomScanner.getScanner().nextDouble();
        System.out.print("Enter sugar content: ");
        sugarContent = CustomScanner.getScanner().nextDouble();
    }

    private static Candy createCandy() {
        System.out.println("\tCandy creating");
        getCommonFields();
        System.out.print("Enter candy type: ");
        CustomScanner.delay();
        String candyType = CustomScanner.getScanner().nextLine();
        return new Candy(name, weight, sugarContent, candyType);
    }

    private static Cookies createCookies() {
        System.out.println("\tCookies creating");
        getCommonFields();
        System.out.print("These are homemade cookies: ");
        boolean isHomeBaking = CustomScanner.getScanner().nextBoolean();
        return new Cookies(name, weight, sugarContent, isHomeBaking);
    }
}
