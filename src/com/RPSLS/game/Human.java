package com.RPSLS.game;

class Human extends Player{

    public void chooseGesture(){}

    @Override
    public String toString() {
        return Human.class.getSimpleName() + " {" +
                "name='" + getName() + '\'' +
                ", wins=" + getWins() +
                ", chosenGesture=" + getChosenGesture() +
                '}';
    }
}