package com.RPSLS.game;

class Computer extends Player{

    @Override
    public void chooseGesture() {
        int randInt = (int)(Math.random() * Gestures.values().length);
        setChosenGesture(Gestures.values()[randInt]);
    }

    @Override
    public String toString() {
        return Computer.class.getSimpleName() + " {" +
                "name='" + getName() + '\'' +
                ", wins=" + getWins() +
                ", chosenGesture=" + getChosenGesture() +
                '}';
    }
}