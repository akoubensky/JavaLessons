package ru.lesson.players;

public class Computer extends Player {
    public Computer(String name) {
        super(name);
    }

    @Override
    public boolean choice() {
        if (value() >= 17) {
            System.out.println("-------------------\n"+"��� ��������� "+"\n"+name+": ��� ������� ������!"+"\n-------------------");
            return false;
        } else {
            getCard();
            System.out.println("-------------------\n"+"��� ��������� "+"\n"+name+": � ������ ��� �����!"+"\n-------------------");
            return true;
        }
    }
}
