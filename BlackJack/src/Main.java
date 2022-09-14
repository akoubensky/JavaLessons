import ru.lesson.cards.*;

public class Main {

    public static void main(String[] args) {
        Suit[] v = Suit.values();
        v[0] = Suit.DIAMONS;
        for (Suit s : v) {
            System.out.println(s);
        }
        for (Rank r : Rank.values()) {
            System.out.println(r + ", " + r.getValue());
        }
        Card c1 = new Card(Suit.SPADES, Rank.SIX);
        System.out.println(c1);

        for (int i = 0; i < 10; i++) {
            System.out.println(Deck.DECK.getCard());
        }
        System.out.println();
        Deck.DECK.sfuffle();
        for (int i = 0; i < 10; i++) {
            System.out.println(Deck.DECK.getCard());
        }
    }
}
