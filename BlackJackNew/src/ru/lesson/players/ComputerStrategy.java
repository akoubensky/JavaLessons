package ru.lesson.players;

public class  ComputerStrategy extends Strategy {

    @Override
    public boolean choice() {
        if (player.value() >= 17) {
            System.out.println("-------------------\n"+"Ход оппонента "+"\n"+player.name+": Мне пожалуй хватит!"+"\n-------------------");
            return false;
        } else {
            player.getCard();
            System.out.println("-------------------\n"+"Ход оппонента "+"\n"+player.name+": Я доберу еще карту!"+"\n-------------------");
            return true;
        }
    }
}
