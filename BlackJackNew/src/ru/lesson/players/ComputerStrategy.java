package ru.lesson.players;

public class  ComputerStrategy extends Strategy {

    @Override
    public boolean choice() {
        if (player.value() >= 17) {
            System.out.println("-------------------\n"+"��� ��������� "+"\n"+player.name+": ��� ������� ������!"+"\n-------------------");
            return false;
        } else {
            player.getCard();
            System.out.println("-------------------\n"+"��� ��������� "+"\n"+player.name+": � ������ ��� �����!"+"\n-------------------");
            return true;
        }
    }
}
