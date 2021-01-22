package com.nechai;
import java.util.Scanner;
import java.io.*;

public class Main {
    private static char ch;
    private static int i;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Моя перша програма");

        System.out.println(ch);
        System.out.println(i);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рядок ");
        String line = scanner.nextLine();

        System.out.println("Введіть ціле число ");
        int i = scanner.nextInt();

        System.out.println("Введіть дробове число ");
        double d = scanner.nextDouble();

        System.out.println(line + "\n" + i + "\n" + d);

        NumbersSet NS1 = new NumbersSet(7, 32, 1);
        NS1.ShowOdd();
        NS1.ShowEven();
        NS1.ShowEvenOddSums();

        System.out.println("Введіть довжина ряду Фібоначчі: ");
        int length = scanner.nextInt();
        NS1.SetLength(length);
        NS1.ShowFibonachi();
    }
}