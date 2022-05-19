package com.RPSLS.game;

import com.RPSLS.templates.DefaultJFrame;
import com.RPSLS.templates.DefaultTextArea;
import com.RPSLS.templates.JPanelBlack;
import com.RPSLS.templates.JRadioButtonHover;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GestureSelectScreen implements ActionListener {
    DefaultJFrame gestureSelectScreen;

    JRadioButtonHover rock;
    JRadioButtonHover paper;
    JRadioButtonHover scissors;
    JRadioButtonHover lizard;
    JRadioButtonHover spock;
    Player player;
    int playerNum;

    GestureSelectScreen(Player player, int playerNum){
        this.player = player;
        this.playerNum = playerNum;

        gestureSelectScreen = new DefaultJFrame(3,1);

        ImageIcon rockImg = new ImageIcon("img/rock.png");
        ImageIcon paperImg = new ImageIcon("img/paper.png");
        ImageIcon scissorsImg = new ImageIcon("img/scissors.png");
        ImageIcon lizardImg = new ImageIcon("img/lizard.png");
        ImageIcon spockImg = new ImageIcon("img/spock.png");

        JPanelBlack playerView = new JPanelBlack();
        String select = player.getName() + " , Please Select A Gesture! ";
        DefaultTextArea playerInfo = new DefaultTextArea(select, 40);
        playerView.add(playerInfo);

        rock = new JRadioButtonHover(rockImg,this);
        paper = new JRadioButtonHover(paperImg, this);
        scissors = new JRadioButtonHover(scissorsImg, this);
        lizard = new JRadioButtonHover(lizardImg, this);
        spock = new JRadioButtonHover(spockImg, this);

        ButtonGroup gestureGroup = new ButtonGroup();
        gestureGroup.add(rock);
        gestureGroup.add(paper);
        gestureGroup.add(scissors);
        gestureGroup.add(lizard);
        gestureGroup.add(spock);

        JPanelBlack buttonContainer = new JPanelBlack();
        buttonContainer.setOpaque(false);
        buttonContainer.setLayout(new FlowLayout());
        buttonContainer.add(rock);
        buttonContainer.add(paper);
        buttonContainer.add(scissors);
        buttonContainer.add(lizard);
        buttonContainer.add(spock);

        gestureSelectScreen.add(playerView);
        gestureSelectScreen.add(buttonContainer);
        gestureSelectScreen.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(playerNum == 1){
            gestureSelect(e, Game.playerOne);

            if(Game.playerTwo.getClass().getSimpleName().equals("Computer")){
                Game.playerTwo.chooseGesture();
                new BattleWinnerScreen();
            }
            else
                new GestureSelectScreen(Game.playerTwo, 2);
        }
            else{
               gestureSelect(e, Game.playerTwo);
                new BattleWinnerScreen();
        }
        gestureSelectScreen.setVisible(false);
    }

    private void gestureSelect(ActionEvent e, Player player){
        if(e.getSource() == rock)
            player.setChosenGesture(Gestures.ROCK);
        else if(e.getSource() == paper)
            player.setChosenGesture(Gestures.PAPER);
        else if(e.getSource() == scissors)
            player.setChosenGesture(Gestures.SCISSORS);
        else if(e.getSource() == lizard)
            player.setChosenGesture(Gestures.LIZARD);
        else if(e.getSource() == spock)
            player.setChosenGesture(Gestures.SPOCK);
        }
}