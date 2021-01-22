package com.nechai;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    private void run() {
        Car[] cars = fillCarsArray();
        System.out.println("---------------------");
        printCars(cars);
        System.out.println("---------------------");
        printCarsWithTheSameModel(cars);
        System.out.println("---------------------");
        printCarsWithTheSameModelAndHigherYear(cars);
        System.out.println("---------------------");
        printCarsWithTheSameYearAndHigherPrice(cars);
    }

    private void printCars(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
    }
    private void printCarsWithTheSameModel(Car[] cars) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть назву моделі про яку хочете дізнатись більше інформації: ");
        String AlikeModels = in.nextLine();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getCarModel().equals(AlikeModels)) {
                System.out.println(cars[i]);
            }
        }
    }
    private void printCarsWithTheSameModelAndHigherYear(Car[] cars) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть модель: ");
        String AlikeModels = in.nextLine();
        System.out.print("Введіть кількість років які повинна експлуатуватись машина: ");
        int carOperatedYears = in.nextInt();
        int mainCarYear = 2020 - carOperatedYears;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getCarModel().equals(AlikeModels)) {
                if (cars[i].getCarYearOutput() <= 2007 && cars[i].getCarYearOutput() >= mainCarYear) {
                    System.out.println(cars[i]);
                }
            }
        }
    }
    private void printCarsWithTheSameYearAndHigherPrice(Car[] cars) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть рік випуску машини: ");
        int minCarYear = in.nextInt();
        System.out.print("Введіть мінімальну ціну: ");
        int minModelsPrice = in.nextInt();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getCarYearOutput() == minCarYear) {
                if (cars[i].getCarPrice() >= minModelsPrice) {
                    System.out.println(cars[i]);
                }
            }
        }
    }
    private Car[] fillCarsArray() {
        return new Car[]{
                new Car(1, "KIA", "BC7741BC", 2015, 22000),
                new Car(2, "Mazda", "BC6995AP", 2016, 15000),
                new Car(3, "BMW", "BC2578AO", 2013, 35000),
                new Car(4, "KIA", "BC2578AY", 2018, 33000),
                new Car(5, "Mitsubishi", "BC5547BC", 2012, 18000),
                new Car(6, "Opel", "BC5505AI", 2016, 5700),
                new Car(7, "Lexus", "AO0001AO", 2017, 42000),
                new Car(8, "Mazda", "BC2134AY", 2011, 30000),
                new Car(9, "Renault", "BC4747BC", 2014, 11000),
                new Car(10, "Mercedes-Benz", "BC5781AI", 2007, 9000),
                new Car(11, "BMW", "BC5220BO", 2010, 30000),
                new Car(12, "Volvo", "BC7770AY", 2009, 12000),
                new Car(13, "Citroen", "BC4446BC", 2008, 6000),
                new Car(14, "Skoda", "BC5755AI", 2019, 24000),
                new Car(15, "Mitsubishi", "BC5001BB", 2002, 10000),
        };
    }
}
