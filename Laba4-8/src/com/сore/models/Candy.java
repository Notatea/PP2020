package com.сore.models;

import com.CustomScanner;

public class Candy extends Sweets {
    private String candyType;

    public Candy(String name, double weight, double sugarContent, String candyType) {
        super(name, weight, sugarContent);
        this.candyType = candyType;
    }

    @Override
    public String toString() {
        return "Candy{ " +
                super.toString() +
                ", candyType='" + candyType + '\'' +
                " }";
    }

    @Override
    public void change() {
        super.change();
        System.out.println("4. Candy type");
        int choice = CustomScanner.getChoice(1, 4);
        if (choice <= 3) {
            changeBaseField(choice);
        } else {
            System.out.print("Enter new value for candy type: ");
            CustomScanner.delay();
            candyType = CustomScanner.getScanner().nextLine();
            System.out.println("Candy type change to \"" + candyType + '"');
        }
        System.out.println(this);
        CustomScanner.delay();
    }
}
