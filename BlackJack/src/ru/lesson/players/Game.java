package ru.lesson.players;
import ru.lesson.cards.Deck;

public class Game {

    private static void play(String humanName) {
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
                boolean b=human.choice();
                if (!b) {

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
        play(args[0]);
    }
}
// ������ � ������, ��������� ����������� �� ������. ����� ���������� � ���� 2 ����������.
