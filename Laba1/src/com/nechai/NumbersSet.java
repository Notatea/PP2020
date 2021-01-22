package com.nechai;

public class NumbersSet {
    int Start;
    int End;
    int Step;
    int Length;


    public NumbersSet(int start, int end, int step){
        Start = start;
        End = end;
        Step = step;
    }

    public void SetLength(int length){
        Length = length;
    }

    public void ShowOdd(){
        System.out.print("Odd numbers: ");
        for(int i = Start; i <= End; i = i + Step){
            if (i%2 != 0) {
                System.out.print(i);
                System.out.print(" ");

            }
        }

        System.out.println();
    }

    public void ShowEven(){
        System.out.print("Even numbers: ");
        for(int i = End; i >= Start; i = i - Step){
            if (i%2 == 0) {
                System.out.print(i);
                System.out.print(" ");

            }
        }
        System.out.println();
    }
    public void ShowEvenOddSums(){
        int sumOdd= 0;
        int sumEven= 0;
        for(int i = Start; i <= End; i = i + Step){
            if (i%2 != 0) {
                sumOdd += i;
            }
            else
            {
                sumEven+= i;
            }
        }
        System.out.println("sumOdd=" + sumOdd);
        System.out.println("sumEven=" + sumEven);
    }


    public void ShowFibonachi()
    {
        int FBNum1 = 0;
        int FBNum2 = 0;
        int newNuber;

        for(int i = Start; i <= End; i = i + Step){
            if (i%2 != 0) {
                FBNum2 = i;
            }
            else
            {
                FBNum1= i;
            }
        }
        int temp;
        if (FBNum1 > FBNum2)
        {
            temp = FBNum2;
            FBNum2 = FBNum1;
            FBNum1 = temp;
        }

        System.out.print("Fibonachi: ");

        double count = 2;
        double countOdd = 1;
        double countEven = 1;

        System.out.print(FBNum1);
        System.out.print(" ");
        System.out.print(FBNum2);
        System.out.print(" ");
        while(true)
        {
            newNuber = FBNum1 + FBNum2;
            if(newNuber % 2 == 0){
                countEven++;
            }else{
                countOdd++;
            }

            System.out.print(newNuber);
            System.out.print(" ");
            FBNum1 = FBNum2;
            FBNum2 = newNuber;
            count ++;
            if (count == Length)
                break;
        }
        double percentOdd = countOdd / count * 100;
        double percentEven = countEven / count * 100;

        System.out.println("\n");
        System.out.println("percentodd=" + percentOdd);
        System.out.println("percenteven=" + percentEven);
    }
}