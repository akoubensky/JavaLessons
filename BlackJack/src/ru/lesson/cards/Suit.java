package ru.lesson.cards;

public enum Suit {
    SPADES("Пик"), CLUBS("Треф"), DIAMONS("Бубей"), HEARTS("Червей");

    private String name;

    Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
