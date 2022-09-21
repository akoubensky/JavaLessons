package ru.lesson.players;

import ru.lesson.cards.Deck;
import ru.lesson.cards.Rank;

import java.util.Scanner;

public class Game {
    private final static Scanner scanner = new Scanner(System.in);

    private static void play(String hunanName) {
        Deck.DECK.sfuffle();
        Player human = new Player(hunanName);
        Player computer = new Player("�����");
        human.getCard();
        human.getCard();

        computer.getCard();
        computer.getCard();

        do {
            if (human.value() < 21) {
                System.out.println(human);
                computer.computerRunning();
                System.out.print("���? (y/n) ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("N")) {

                    int i=1;
                    while (i==1) {
                        i=computer.computerRunning();
                    }
// TODO � ������� switch () �������.
                    if (human.value()>computer.value()) {
                        System.out.println(human +"\n"+"\n"+ computer+"\n"+"\n" + "� ��� ������ �����! �� ��������!");
                        break;
                    } else if (human.value()==computer.value()) {
                        System.out.println(human +"\n"+"\n"+ computer+"\n"+"\n" + "� ��� ��������� �����! �����!");
                        break;
                    } else if (computer.value()>22) {
                        System.out.println(human + "\n" + "\n" + computer + "\n" + "\n" + "� ��������� ��������! �� ��������!");
                        break;
                    }
                    System.out.println(human +"\n"+"\n"+ computer+"\n"+"\n" + "� ��� ������ �����! �� ���������!");
                    break;

                }
                if (answer.equalsIgnoreCase("Y")) {
                    human.getCard();
                } else {
                    System.out.println("����?");
                }
            }
        } while (human.value() < 21);
        if (human.value() == 21) {
            System.out.println(human +"\n"+"\n"+ computer+"\n"+"\n" + "� ��� ����! �� ��������!");
        }
        if (human.value() > 21) {
            System.out.println(human+"\n"+"\n"+ computer+"\n"+"\n" +"�������! �� ���������!");
//            return;
        }
    }

    public static void main(String[] args) {

        play(args[1]);
    }
}
