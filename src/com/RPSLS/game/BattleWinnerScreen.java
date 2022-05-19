package com.RPSLS.game;

import com.RPSLS.templates.DefaultJFrame;
import com.RPSLS.templates.DefaultTextArea;
import com.RPSLS.templates.JButtonHover;
import com.RPSLS.templates.JPanelBlack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleWinnerScreen implements ActionListener {
    DefaultJFrame battleWinnerScreen;
    JButtonHover nextButton;

    public BattleWinnerScreen(){
        battleWinnerScreen = new DefaultJFrame(4,1);
        String message = Game.determineWinner(Game.playerOne.getChosenGesture(), Game.playerTwo.getChosenGesture());

        JPanelBlack scoreWinner = new JPanelBlack();
        scoreWinner.setLayout(new GridLayout(1,2));

        JPanelBlack leftScore = new JPanelBlack();
        JPanelBlack rightScore = new JPanelBlack();

        String playerOneWins = Game.playerOne.getName() +
                "\n-------------\n" +
                Game.playerOne.getWins();
        DefaultTextArea playerOneScore = new DefaultTextArea(playerOneWins, 40);
        leftScore.add(playerOneScore, BorderLayout.EAST);
        scoreWinner.add(leftScore);

        String playerTwoWins = Game.playerTwo.getName() +
                "\n-------------\n" +
                Game.playerTwo.getWins();
        DefaultTextArea playerTwoScore = new DefaultTextArea(playerTwoWins, 40);
        rightScore.add(playerTwoScore, BorderLayout.WEST);
        scoreWinner.add(rightScore);

        JPanelBlack displayWinner = new JPanelBlack();
        String winnerText = Game.playerOne.getName() + " chose " +
                Game.playerOne.getChosenGesture() + "!\n" +
                Game.playerTwo.getName() + " chose " +
                Game.playerTwo.getChosenGesture() + "!\n\n" +
                message;
        DefaultTextArea winner = new DefaultTextArea(winnerText, 40);
        displayWinner.add(winner);

        JPanelBlack nextButtonCon = new JPanelBlack();
        nextButton = new JButtonHover("Next Round", this);
        nextButtonCon.add(nextButton);

        battleWinnerScreen.add (scoreWinner);
        battleWinnerScreen.add(displayWinner);
        battleWinnerScreen.add(nextButtonCon);
        battleWinnerScreen.validate();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton)
            Game.battle();
        battleWinnerScreen.setVisible(false);
    }
}