package com.RPSLS.game;

abstract class Player {
    private String name;
    private int wins;
    private Gestures chosenGesture;

    public abstract void chooseGesture();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.length() == 0 ? "Default" : name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public Gestures getChosenGesture() {
        return chosenGesture;
    }

    public void setChosenGesture(Gestures chosenGesture) {
        this.chosenGesture = chosenGesture;
    }

    @Override
    public String toString() {
        return Player.class.getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", chosenGesture=" + chosenGesture +
                '}';
    }
}