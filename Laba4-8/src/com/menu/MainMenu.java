package com.menu;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {

    private static Map<Integer, MenuItem> menuCommands;

    static {
        menuCommands = new HashMap<>();
        menuCommands.put(1, new CreateSweetsCommand());
        menuCommands.put(2, new PrintCreatedSweetsCommand());
        menuCommands.put(3, new ChangeSweetsCommand());
        menuCommands.put(4, new CreateGiftCommand());
        menuCommands.put(5, new PrintCreatedGiftsCommand());
        menuCommands.put(6, new ChangeGiftCommand());
        menuCommands.put(7, new SortSweetsCommand());
        menuCommands.put(8, new FindSweetsCommand());
        menuCommands.put(9, new ExitCommand());
    }

    public void execute(int command) {
        if (menuCommands.containsKey(command)) {
            menuCommands.get(command).execute();
        } else {
            System.out.println("Invalid command");
        }
    }

    @Override
    public String toString() {
        return "\n\n1. Create new sweets\n" +
                "2. Print created sweets\n" +
                "3. Change sweets\n" +
                "4. Create gift\n" +
                "5. Print created gifts\n" +
                "6. Change gift\n" +
                "7. Sort sweets in the gift\n" +
                "8. Find sweets in the gift\n" +
                "9. Exit";
    }
}
