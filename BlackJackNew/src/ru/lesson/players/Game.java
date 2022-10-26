package ru.lesson.players;

import ru.lesson.cards.Deck;

import java.util.Scanner;

public class Game {

    private static void play(String humanName) {
//        Player player=new Player(name, new PlayerStrategy(���� ����������))
        Deck.DECK.sfuffle();
        Player human = new Human(humanName);
        Player computer = new Computer("�����");
        human.getCard();
        human.getCard();

        computer.getCard();
        computer.getCard();

        // � ���� ����� ��������� ����� �������� �� ���� while() {}
        while (human.value() < 21) {
                System.out.println(human);
                // ����� computerRunning ������� ����������, ������� ��� �� ����� ������ Player
                // ��������, ������� ��-���� ������� ���������, � ����� getCard ������������� ��-�������
                computer.choice(); // ���������� �� ����, ���� �� ������� ����� �����, ��������� �� ����� ����� ��������

                if (!human.choice()) {

                    boolean i=true;
                    while (i) {

                        i=computer.choice();
                    }
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
        }
        if (human.value() == 21) {
            System.out.println(human +"\n"+"\n"+ computer+"\n"+"\n" + "� ��� ����! �� ��������!");
        }
        if (human.value() > 21) {
            System.out.println(human+"\n"+"\n"+ computer+"\n"+"\n" +"�������! �� ���������!");
        }
    }

    public static void main(String[] args) {
        // ������� ����� ���� �������� ����� "������� ���? (y/n)"
        Scanner scanner = new Scanner(System.in);
        String answer=null;
        do {
            if (answer==null){
                play(args[0]);
            }
            System.out.print("������� ���? (y/n)");
            answer = scanner.nextLine();

            while ((!answer.equalsIgnoreCase("N"))&&!answer.equalsIgnoreCase("Y")) {
                System.out.println("����?");
                System.out.print("������� ���? (y/n)");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("Y")) {
                play(args[0]);
            }
        } while (!(answer.equalsIgnoreCase("N")));
        System.out.println("���� ����������!");
    }
}
// ���������� ����� ����� � �� ����.
// ������ � ������, ��������� ����������� �� ������. ����� ���������� � ���� 2 ����������.
