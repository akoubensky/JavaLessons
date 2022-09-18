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
            System.out.println("� ���� �������... �� ��������!");
        } else if (compValue == humanValues) {
            System.out.println("�����.");
        } else if (compValue > humanValues) {
            System.out.println("� ���� ������, � �������");
        } else {
            System.out.println("� ��� ������, ����������!");
        }
    }

    public static void main(String[] args) {
        String humanName;
        String answer;
        if (args.length > 0) {
            humanName = args[0];
        } else {
            System.out.print("������� ���� ���: ");
            humanName = scanner.nextLine();
        }
        do {
            play(humanName);
            System.out.print("������� ���? (y/n) ");
            answer = scanner.nextLine();
        } while (answer.equalsIgnoreCase("Y"));
    }
}
