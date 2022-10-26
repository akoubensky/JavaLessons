package ru.lesson.cards;

public enum Suit {
    SPADES("���"), CLUBS("����"), DIAMONS("�����"), HEARTS("������");

    private String name;

    Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
