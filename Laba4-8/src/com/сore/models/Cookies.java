package com.сore.models;

import com.CustomScanner;

public class Cookies extends Sweets{
    private boolean isHomeBaking;

    public Cookies(String name, double weight, double sugarContent,
                   boolean isHomeBaking) {
        super(name, weight, sugarContent);
        this.isHomeBaking = isHomeBaking;
    }

    @Override
    public String toString() {
        return "Cookies{ " +
                super.toString() +
                ", isHomeBaking=" + isHomeBaking +
                " }";
    }

    @Override
    public void change() {
        super.change();
        System.out.println("4. Is home baking");
        int choice = CustomScanner.getChoice(1, 4);
        if (choice <= 3) {
            changeBaseField(choice);
        } else {
            System.out.print("Enter new value for is home baking: ");
            isHomeBaking = CustomScanner.getScanner().nextBoolean();
        }
        System.out.println(this);
        CustomScanner.delay();
    }
}
