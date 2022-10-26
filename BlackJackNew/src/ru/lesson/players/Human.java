package ru.lesson.players;

import java.util.Scanner;

public class Human extends Player {
    private final static Scanner scanner = new Scanner(System.in);
    public Human(String name) {
        super(name);
    }

    @Override
    public boolean choice() {
        System.out.print("Ещё? (y/n) ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("N")) {
            return false;
        }
        if (answer.equalsIgnoreCase("Y")) {
            getCard();
            return true;
        } else {
            System.out.println("Чего?");
        }
        return choice();
    }
}