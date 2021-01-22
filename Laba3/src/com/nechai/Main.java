package com.nechai;
import java.util.Scanner;

import arena.Arena;
import droids.Team;
import droids.*;

public class Main {

    static Arena game;
    public static void main(String[] args) {
        game = new Arena();

        teamSetupAction(game.team1);
        teamSetupAction(game.team2);

        System.out.println("Бій : ");

        Fight.startFight(game.team1, game.team2);

    }

    public static void teamSetupAction(Team team){
        System.out.println("Команда " + team.Name);
        printTeamMenu();
        while(true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Виберіть дію :");
            int i = scanner.nextInt();

            switch(i)
            {
                case 1 :
                    team.addDroid();
                    break;
                case 2 :
                    team.showInfo();
                    break;
                case 3 :
                    return;
            }
        }
    }

    public static void printTeamMenu(){
        System.out.println("Меню:");
        System.out.println("1. Створити дроїда і додати в команду.");
        System.out.println("2. Показати список створених дроїдів.");
        System.out.println("3. Закінчити роботу з командою, перейти на наступний крок.");
    }


}

