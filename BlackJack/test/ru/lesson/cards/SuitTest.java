package ru.lesson.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void testToString() {
        assertEquals("���", Suit.SPADES.toString());
        assertEquals("����", Suit.CLUBS.toString());
        assertEquals("�����", Suit.DIAMONS.toString());

    }
}