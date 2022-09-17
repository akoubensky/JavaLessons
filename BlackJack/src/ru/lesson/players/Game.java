package ru.lesson.players;

import ru.lesson.cards.Deck;

import java.util.Scanner;

public class Game {
    private final static Scanner scanner = new Scanner(System.in);

    private static void play(String hunanName) {
        Deck.DECK.sfuffle();
        Player human = new Player(hunanName);
        Player computer = new Player("�����");
        human.getCard();
        human.getCard();
        do {
            if (human.value() < 20) {
                System.out.println(human);
                System.out.print("���? (y/n) ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("N")) break;
                if (answer.equalsIgnoreCase("Y")) {
                    human.getCard();
                } else {
                    System.out.println("����?");
                }
            }
        } while (human.value() < 20);
        if (human.value() > 21) {
            System.out.println("�������! �� ���������!");
            return;
        }
    }

    public static void main(String[] args) {
        play(args[0]);
    }
}
