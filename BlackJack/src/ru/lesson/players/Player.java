package ru.lesson.players;

import ru.lesson.cards.Card;
import ru.lesson.cards.Deck;

import java.util.ArrayList;

public class Player {
    private final ArrayList<Card> hand = new ArrayList<>(8);
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void getCard() {
        hand.add(Deck.DECK.getCard());
    }

    public int value() {
        int summa = 0;
        for(Card c : hand) {
            summa += c.getValue();
        }
        return hand.size() == 2 && summa == 22 ? 21 : summa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append("\n-------------------\n");
        for(Card c : hand) {
            sb.append(c.toString()).append("\n");
        }
        sb.append("-------------------\n").append("Всего: ").append(value());
        return sb.toString();
    }
}
