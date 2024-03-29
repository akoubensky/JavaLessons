package ru.lesson.players;

import ru.lesson.cards.Card;
import ru.lesson.cards.Deck;

import java.util.ArrayList;

public abstract class Player {
    private final ArrayList<Card> hand = new ArrayList<>(8);
    protected final String name;

    public Player(String name) {
        this.name = name;
    }

    public void getCard() {
        hand.add(Deck.DECK.getCard());
    }
    public abstract boolean choice ();
//    2 ����� ������ ������� ������ ���� ������������ � � ��� ������ ���� ����������� ��� ������� ������� ����� �������� �� ��� ������.

//    ����� ���������.

    public int value() {
        int summa = 0;
        for(Card c : hand) {
            summa += c.getValue();
        }
        return hand.size() == 2 && summa == 22 ? 21 : summa;
    }
    // � ���� ������ ����� ���������� ���������� �������� (boolean)
//    public int computerRunning () {
//        if (value() >= 17) {
//            System.out.println("-------------------\n"+"��� ��������� "+"\n"+name+": ��� ������� ������!"+"\n-------------------");
//            return 0;
//        } else {
//            getCard();
//            System.out.println("-------------------\n"+"��� ��������� "+"\n"+name+": � ������ ��� �����!"+"\n-------------------");
//            return 1;
//        }
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append("\n-------------------\n");
        for(Card c : hand) {
            sb.append(c.toString()).append("\n");
        }
        sb.append("-------------------\n").append("�����: ").append(value());
        return sb.toString();
    }
    public Player(String name, Strategy strategy) {
        strategy.setPlayer(this);
        this.name = name;
    }
}
