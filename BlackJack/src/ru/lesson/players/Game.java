package ru.lesson.players;

import ru.lesson.cards.Deck;

import java.util.Scanner;

public class Game {
    private final static Scanner scanner = new Scanner(System.in);

    private static void play(String hunanName) {
        Deck.DECK.sfuffle();
        Player human = new Player(hunanName);
        Player computer = new Player("Робот");
        human.getCard();
        human.getCard();
        do {
            if (human.value() < 20) {
                System.out.println(human);
                System.out.print("Ещё? (y/n) ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("N")) break;
                if (answer.equalsIgnoreCase("Y")) {
                    human.getCard();
                } else {
                    System.out.println("Чего?");
                }
            }
        } while (human.value() < 20);
        if (human.value() > 21) {
            System.out.println("Перебор! Вы проиграли!");
            return;
        } else if (human.value() >= 20) {
            System.out.println(human);
        }

        int humanValues = human.value();
        do {
            computer.getCard();
        } while (computer.value() < 16);
        int compValue = computer.value();
        System.out.println(computer);
        if (compValue > 21) {
            System.out.println("У меня перебор... Вы выиграли!");
        } else if (compValue == humanValues) {
            System.out.println("Ничья.");
        } else if (compValue > humanValues) {
            System.out.println("У меня больше, я выиграл");
        } else {
            System.out.println("У вас больше, поздравляю!");
        }
    }

    public static void main(String[] args) {
        String humanName;
        String answer;
        if (args.length > 0) {
            humanName = args[0];
        } else {
            System.out.print("Введите свое имя: ");
            humanName = scanner.nextLine();
        }
        do {
            play(humanName);
            System.out.print("Сыграем еще? (y/n) ");
            answer = scanner.nextLine();
        } while (answer.equalsIgnoreCase("Y"));
    }
}
