package com.RPSLS.game;

import com.RPSLS.templates.DefaultJFrame;
import com.RPSLS.templates.JButtonHover;
import com.RPSLS.templates.JPanelBlack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ChooseGameType implements ActionListener {
    DefaultJFrame chooseGameType;
    JButtonHover hvhButton;
    JButtonHover hvcButton;

    ChooseGameType(){
        chooseGameType = new DefaultJFrame(2,1);

        JPanelBlack buttonContainer = new JPanelBlack();
        hvhButton = new JButtonHover("HUMAN VS HUMAN", this);
        buttonContainer.add(hvhButton);

        hvcButton = new JButtonHover("HUMAN VS COMPUTER", this);
        buttonContainer.add(hvcButton);

        chooseGameType.add(buttonContainer);
        chooseGameType.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == hvhButton) {
            Game.playerOne.setName(nameDialog("Player 1"));
            Game.playerTwo = new Human();
            Game.playerTwo.setName(nameDialog("Player 2"));
        }
        else {
            Game.playerOne.setName(nameDialog("Player 1"));
            Game.playerTwo = new Computer();
            Game.playerTwo.setName("C3PO");
        }
        Game.battle();
        chooseGameType.setVisible(false);
    }

    private String nameDialog(String player){
        return JOptionPane.showInputDialog(player + ", What is your Name?");
    }
}