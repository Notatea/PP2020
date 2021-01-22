package com.сore.models;

import com.CustomScanner;

public abstract class Sweets {
    private String name;
    private double weight;
    private double sugarContent;

    public Sweets(String name, double weight, double sugarContent) {
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", weight=" + weight +
                ", sugarContent=" + sugarContent;
    }

    public void change() {
        System.out.println("What do you want to change:");
        System.out.println("1. Name");
        System.out.println("2. Weight");
        System.out.println("3. Sugar content");
    }

    protected void changeBaseField(int choice) {
        if (choice == 1) {
            System.out.print("Enter new name: ");
            CustomScanner.delay();
            name = CustomScanner.getScanner().nextLine();
            System.out.println("Name change to \"" + name + "\"");
        } else if (choice == 2) {
            System.out.print("Enter new weight: ");
            weight = CustomScanner.getScanner().nextDouble();
            System.out.println("Weight change to " + weight);
        } else {
            System.out.print("Enter new sugar content: ");
            sugarContent = CustomScanner.getScanner().nextDouble();
            System.out.println("Sugar content change to " + sugarContent);
        }
    }
}
