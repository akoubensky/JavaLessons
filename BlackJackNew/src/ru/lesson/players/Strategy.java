package ru.lesson.players;

public abstract class Strategy {
    public abstract boolean choice ();
    protected Player player;
    public void setPlayer (Player player){
        this.player=player;
    }
}
