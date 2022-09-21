package ru.lesson.players;

import ru.lesson.cards.Deck;
import ru.lesson.cards.Rank;

import java.util.Scanner;

public class Game {
    private final static Scanner scanner = new Scanner(System.in);

    private static void play(String hunanName) {
        Deck.DECK.sfuffle();
        Player human = new Player(hunanName);
        Player computer = new Player("Робот");
        human.getCard();
        human.getCard();

        computer.getCard();
        computer.getCard();

        do {
            if (human.value() < 21) {
                System.out.println(human);
                computer.computerRunning();
                System.out.print("Ещё? (y/n) ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("N")) {

                    int i=1;
                    while (i==1) {
                        i=computer.computerRunning();
                    }
// TODO С помощью switch () сделать.
                    if (human.value()>computer.value()) {
                        System.out.println(human +"\n"+"\n"+ computer+"\n"+"\n" + "У вас больше очков! Вы выиграли!");
                        break;
                    } else if (human.value()==computer.value()) {
                        System.out.println(human +"\n"+"\n"+ computer+"\n"+"\n" + "У вас одинаково очков! Ничья!");
                        break;
                    } else if (computer.value()>22) {
                        System.out.println(human + "\n" + "\n" + computer + "\n" + "\n" + "У оппонента пееребор! Вы выиграли!");
                        break;
                    }
                    System.out.println(human +"\n"+"\n"+ computer+"\n"+"\n" + "У вас меньше очков! Вы проиграли!");
                    break;

                }
                if (answer.equalsIgnoreCase("Y")) {
                    human.getCard();
                } else {
                    System.out.println("Чего?");
                }
            }
        } while (human.value() < 21);
        if (human.value() == 21) {
            System.out.println(human +"\n"+"\n"+ computer+"\n"+"\n" + "У вас Очко! Вы выиграли!");
        }
        if (human.value() > 21) {
            System.out.println(human+"\n"+"\n"+ computer+"\n"+"\n" +"Перебор! Вы проиграли!");
//            return;
        }
    }

    public static void main(String[] args) {

        play(args[1]);
    }
}
