package com.RPSLS.game;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static com.RPSLS.game.Gestures.*;

public class Game {
    public static Player playerOne = new Human();
    public static Player playerTwo;
    public static int gameWins = 3;

    private static String printGestureWinnerAction(Gestures winningGesture, int index) {
        TreeMap<Gestures, ArrayList<String>> gestureAction = new TreeMap<>();
        gestureAction.put(ROCK, new ArrayList<>(List.of("Rock crushes Scissors", "Rock crushes Lizard")));
        gestureAction.put(PAPER, new ArrayList<>(List.of("Paper covers Rock", "Paper disproves Spock")));
        gestureAction.put(SCISSORS, new ArrayList<>(List.of("Scissors cuts Paper", "Scissors decapitates Lizard")));
        gestureAction.put(LIZARD, new ArrayList<>(List.of("Lizard eats Paper", "Lizard poisons Spock")));
        gestureAction.put(SPOCK, new ArrayList<>(List.of("Spock vaporizes Rock", "Spock smashes Scissors")));

        return gestureAction.get(winningGesture).get(index);
    }

    public static String determineWinner(Gestures gestureOne, Gestures gestureTwo) {

        TreeMap<Gestures, ArrayList<Gestures>> logicTest = new TreeMap<>();
        logicTest.put(ROCK, new ArrayList<>(List.of(SCISSORS, LIZARD)));
        logicTest.put(PAPER, new ArrayList<>(List.of(ROCK, SPOCK)));
        logicTest.put(SCISSORS, new ArrayList<>(List.of(PAPER, LIZARD)));
        logicTest.put(LIZARD, new ArrayList<>(List.of(PAPER, SPOCK)));
        logicTest.put(SPOCK, new ArrayList<>(List.of(ROCK, LIZARD)));

        if (gestureOne == gestureTwo)
            return ("It is a tie");

        if (logicTest.get(gestureOne).contains(gestureTwo)) {
            int index = logicTest.get(gestureOne).indexOf(gestureTwo);
            String action = printGestureWinnerAction(gestureOne, index);
            playerOne.setWins(playerOne.getWins() + 1);
            return (action+ "\n" + playerOne.getName() + " wins!!");

        } else {
            int index = logicTest.get(gestureTwo).indexOf(gestureOne);
            String action = printGestureWinnerAction(gestureTwo, index);
            playerTwo.setWins(playerTwo.getWins() + 1);
            return (action+ "\n" + playerTwo.getName() + " wins!!");
        }
    }

    public static String determineOverallWinner() {
        if (playerOne.getWins() > playerTwo.getWins())
            return (playerOne.getName());
        else
            return (playerTwo.getName());
    }

    public static void battle() {
        playerOne.setChosenGesture(null);
        playerTwo.setChosenGesture(null);
        if (playerOne.getWins() < gameWins && playerTwo.getWins() < gameWins)
            new GestureSelectScreen(playerOne, 1);
        else {
            int answer = JOptionPane.showConfirmDialog(null, "Would you like to continue?", "We have a winner!", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                gameWins += 3;
                battle();
            } else
                new FinalScreen();
        }
    }

    public static void runGame() {
        playerOne = new Human();
        new WelcomeScreen();
    }
}


