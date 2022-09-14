package ru.lesson.cards;

public enum Rank {
    SIX(6, "��������"), SEVEN(7, "�������"), EIGHT(8, "���������"), NINE(9, "�������"),
    TEN(10, "�������"), JACK(2, "�����"), QUEEN(3, "����"), KING(4, "������"), ACE(11, "���");

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
