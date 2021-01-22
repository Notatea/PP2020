package com.сore.models;

import com.CustomScanner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gift {
    private List<Sweets> sweets;
    private String name;

    public Gift(String name, List<Sweets> sweets) {
        this.sweets = sweets;
        this.name = name;
    }

    public void sort() {
        int choice = getParameter("sort the sweets");

        if (choice == 1) {
            sweets.sort(Comparator.comparing(Sweets::getName));
        } else if (choice == 2) {
            sweets.sort(Comparator.comparing(Sweets::getWeight));
        } else {
            sweets.sort(Comparator.comparing(Sweets::getSugarContent));
        }
    }

    public void findSweetsInGift() {
        int choice = getParameter("look for sweets");

        if (choice == 1) {
            findByName();
        } else if (choice == 2) {
            findByWeight();
        } else {
            findBySugarContent();
        }
    }

    private void findByWeight() {
        System.out.println("Enter the weight limits to search: ");
        System.out.print("Min weight: ");
        int min = CustomScanner.getScanner().nextInt();
        System.out.print("Max weight: ");
        int max = CustomScanner.getScanner().nextInt();

        printSearchResult(sweets.stream().filter(sweet ->
                sweet.getWeight() >= min && sweet.getWeight() <= max)
                .collect(Collectors.toList()));
    }

    private void findByName() {
        System.out.println("Enter name for searching: ");
        CustomScanner.delay();
        String nameForSearching = CustomScanner.getScanner().nextLine();

        printSearchResult(sweets.stream().filter(sweet ->
                sweet.getName().toLowerCase(Locale.ROOT).contains(nameForSearching.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList()));
    }

    private void printSearchResult(List<Sweets> foundSweets) {
        if (foundSweets.size() == 0) {
            System.out.println("No sweets were found for the specified parameter");
        } else {
            foundSweets.forEach(System.out::println);
        }
    }

    private void findBySugarContent() {
        System.out.println("Enter the sugar content limits to search: ");
        System.out.print("Min sugar content: ");
        int min = CustomScanner.getScanner().nextInt();
        System.out.print("Max sugar content: ");
        int max = CustomScanner.getScanner().nextInt();

        printSearchResult(sweets.stream().filter(sweet ->
                sweet.getSugarContent() >= min && sweet.getSugarContent() <= max)
                .collect(Collectors.toList()));
    }

    private int getParameter(String message) {
        System.out.println("By what parameter do you want to " + message);
        System.out.println("1. Name \n2. Weight \n3. Sugar content");
        return CustomScanner.getChoice(1, 3);
    }

    @Override
    public String toString() {
        String result = "Gift{ \n\tName = \"" + name + "\",\n\tSweets{";
        for (Sweets sweet : sweets) {
            result += "\n\t\t" + sweet;
        }
        result += "\n\t}\n}\n";
        return result;
    }

    public void addNewSweets(List<Sweets> newSweets) {
        sweets.addAll(newSweets);
    }

    public void removeSweets() {
        if (!printCreatedSweets()) {
            return;
        }
        System.out.println("Enter the numbers of sweets you want to remove from a gift:");

        List<Integer> indexOfSweetsForDeleting = new ArrayList<>();
        while (CustomScanner.getScanner().hasNextInt()) {
            int index = CustomScanner.getScanner().nextInt();
            if (index < 1 || index > sweets.size()) {
                break;
            }
            indexOfSweetsForDeleting.add(index - 1);
        }

        indexOfSweetsForDeleting.sort(Collections.reverseOrder());

        indexOfSweetsForDeleting.forEach(index -> sweets.remove((int)index));
    }

    private boolean printCreatedSweets() {
        if (sweets.size() == 0) {
            System.out.println("You have not added any sweets yet");
            return false;
        }
        System.out.println("\tAdded sweets");
        IntStream.range(0, sweets.size())
                .mapToObj(i -> (i + 1) + ". " + sweets.get(i))
                .forEach(System.out::println);

        return true;
    }
}
