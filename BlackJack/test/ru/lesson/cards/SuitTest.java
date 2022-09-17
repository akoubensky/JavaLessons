package ru.lesson.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void testToString() {
        assertEquals("Пик", Suit.SPADES.toString());
        assertEquals("Треф", Suit.CLUBS.toString());
        assertEquals("Бубей", Suit.DIAMONS.toString());

    }
}