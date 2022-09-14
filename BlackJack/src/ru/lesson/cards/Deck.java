package ru.lesson.cards;

import java.util.Random;

public class Deck {
    public final int CARDS_NUMBER = 36;

    public static final Deck DECK = new Deck();
    private static Random random = new Random();

    private Card[] deck = new Card[CARDS_NUMBER];
    private int count;

    private Deck() {
        count = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck[count++] = new Card(suit, rank);
            }
        }
    }

    private void swap(int i, int j) {
        Card c = deck[i];
        deck[i] = deck[j];
        deck[j] = c;
    }

    public Card getCard() {
        int rIndex = random.nextInt(count);
        Card card = deck[rIndex];
        swap(rIndex, --count);
        return card;
    }

    public void sfuffle() {
        count = CARDS_NUMBER;
    }
}
