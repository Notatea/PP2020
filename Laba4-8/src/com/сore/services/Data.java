package com.сore.services;

import com.CustomScanner;
import com.сore.models.Candy;
import com.сore.models.Cookies;
import com.сore.models.Gift;
import com.сore.models.Sweets;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static List<Sweets> createdSweets = new ArrayList<>();

    private static List<Gift> createdGifts = new ArrayList<>();

    static {
        createdSweets.add(new Candy("Candy 1", 50, 5, "Chocolate"));
        createdSweets.add(new Cookies("Cookies 1", 20, 10, true));
        createdSweets.add(new Candy("Candy 2", 60, 15, "Caramel"));

        createdGifts.add(new Gift("Gift 1", createdSweets));
    }

    public static void addSweets(Sweets sweets) {
        createdSweets.add(sweets);
    }

    public static void changeSweets() {
        if (!printCreatedSweets()) {
            return;
        }
        System.out.println("Enter number of sweets what do you want to change: ");
        int choice = CustomScanner.getChoice(1, createdSweets.size());
        createdSweets.get(choice - 1).change();
    }

    public static void createGift() {
        if (createdSweets.size() == 0) {
            System.out.println("To create a gift, first create sweets");
            return;
        }

        System.out.print("Enter name: ");
        CustomScanner.delay();
        String name = CustomScanner.getScanner().nextLine();
        Gift gift = new Gift(name, getSweetsForAddingToGift());

        createdGifts.add(gift);
        System.out.println(gift);
    }

    public static void changeGift() {
        if (!printCreatedGifts()) {
            return;
        }

        Gift gift = chooseGift("what do you want to change");

        System.out.println("What do you want to do");
        System.out.println("1. Add new sweets to a gift");
        System.out.println("2. Delete sweets from a gift");

        int choice = CustomScanner.getChoice(1, 2);
        if (choice == 1) {
            gift.addNewSweets(getSweetsForAddingToGift());
        } else {
            gift.removeSweets();
        }
        System.out.println("\n\tChanged gift\n" + gift);
    }

    private static List<Sweets> getSweetsForAddingToGift() {
        printCreatedSweets();
        System.out.println("Enter the numbers of sweets you want to add in a gift");

        List<Sweets> sweets = new ArrayList<>();
        while (CustomScanner.getScanner().hasNextInt()) {
            int choice = CustomScanner.getScanner().nextInt();
            if (choice < 1 || choice > createdSweets.size()) {
                break;
            }
            sweets.add(createdSweets.get(choice - 1));
        }

        return sweets;
    }

    private static Gift chooseGift(String message) {
        System.out.println("Enter number of gifts " + message + ": ");
        int choice = CustomScanner.getChoice(1, createdGifts.size());
        return createdGifts.get(choice - 1);
    }

    public static void findSweetsInTheGift() {
        if (!printCreatedGifts()) {
            return;
        }

        Gift gift = chooseGift("in which you want to look for sweets");
        gift.findSweetsInGift();
    }

    public static void sortSweetsInTheGift() {
        if (!printCreatedGifts()) {
            return;
        }

        Gift gift = chooseGift("do you want to choose for sorting");
        gift.sort();
        System.out.println("\tSorted gift\n" + gift);
    }

    public static boolean printCreatedSweets() {
        if (createdSweets.size() == 0) {
            System.out.println("You have not created any sweets yet");
            return false;
        }
        System.out.println("\tCreated sweets");
        for (int i = 0; i < createdSweets.size(); i++) {
            System.out.println((i + 1) + ". " + createdSweets.get(i));
        }

        return true;
    }

    public static boolean printCreatedGifts() {
        if (createdGifts.size() == 0) {
            System.out.println("You have not created any gifts yet");
            return false;
        }
        System.out.println("\tCreated gifts");
        for (int i = 0; i < createdGifts.size(); i++) {
            System.out.println((i + 1) + ". " + createdGifts.get(i));
        }

        return true;
    }
}
