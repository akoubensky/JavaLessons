package ru.lesson.cards;

public enum Rank {
    SIX(6, "Шестерка"), SEVEN(7, "Сеиерка"), EIGHT(8, "Восьмерка"), NINE(9, "Девятка"),
    TEN(10, "Десятка"), JACK(2, "Валет"), QUEEN(3, "Дама"), KING(4, "Король"), ACE(11, "Туз");

    private final int value;
    private final String name;

    Rank(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return name;
    }
}
