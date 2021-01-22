package com;

import java.util.Scanner;

public class CustomScanner {
    private static Scanner in;

    static {
        in = new Scanner(System.in);
    }

    public static Scanner getScanner() {
        return in;
    }

    public static int getChoice(int min, int max) {
        if (in.hasNextInt()) {
            int choice = in.nextInt();
            if (min <= choice && choice <= max) {
                return choice;
            }
        }
        System.out.println("Invalid number");
        return getChoice(min, max);
    }

    public static void delay() {
        in.nextLine();
    }
}
