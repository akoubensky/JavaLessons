package ru.lesson.players;
import ru.lesson.cards.Deck;

public class Game {

    private static void play(String humanName) {
        Deck.DECK.sfuffle();
        Player human = new Human(humanName);
        Player computer = new Computer("Робот");
        human.getCard();
        human.getCard();

        computer.getCard();
        computer.getCard();

        // В этой схеме программы лучше заменить на цикл while() {}
        while (human.value() < 21) {
                System.out.println(human);
                // Метод computerRunning слишком специфичен, поэтому это не метод класса Player
                // Возможно, игроков всё-таки следует различать, и метод getCard реализовывать по-разному
                computer.choice(); // Независимо от того, надо ли реально брать карту, сообщение всё равно будет выведено
                boolean b=human.choice();
                if (!b) {

                    boolean i=true;
                    while (i) {
                        i=computer.choice();
                    }
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
        }
        if (human.value() == 21) {
            System.out.println(human +"\n"+"\n"+ computer+"\n"+"\n" + "У вас Очко! Вы выиграли!");
        }
        if (human.value() > 21) {
            System.out.println(human+"\n"+"\n"+ computer+"\n"+"\n" +"Перебор! Вы проиграли!");
        }
    }

    public static void main(String[] args) {
        // Давайте здесь тоже зациклим через "Сыграем ещё? (y/n)"
        play(args[0]);
    }
}
// Логику в игрока, клмпьютер наследуется от игрока. Плеер абстракный у него 2 наследника.
