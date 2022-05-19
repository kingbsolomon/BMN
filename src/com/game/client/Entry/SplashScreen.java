package com.game.client.Entry;

import com.RPSLS.templates.DefaultJFrame;
import com.RPSLS.templates.JButtonHover;
import com.RPSLS.templates.JPanelBlack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreen implements ActionListener {

    JButtonHover rpslsButton;
    JButtonHover tttButton;
    DefaultJFrame defaultJFrame;
    public SplashScreen(){
        String bannerPath = "img/game_center_banner.png";
        defaultJFrame =  new DefaultJFrame(bannerPath,2,1, "Game Center");
        JPanelBlack rpslsButtonPanel = new JPanelBlack();
        JPanelBlack tttButtonPanel = new JPanelBlack();

        ImageIcon image1 = new ImageIcon("img/Play_1.png");
        ImageIcon image2 = new ImageIcon("img/Play_2.png");

        rpslsButton = new JButtonHover("RPSLS", this);
        rpslsButton.setText("");
        rpslsButton.setIcon(image1);
        rpslsButtonPanel.add(rpslsButton);

        tttButton = new JButtonHover("Tic Tac Toe", this);
        tttButton.setIcon(image2);
        tttButton.setText("");
        tttButtonPanel.add(tttButton);

        JPanelBlack container = new JPanelBlack();
        container.setLayout(new FlowLayout());
        container.add(rpslsButtonPanel);
        container.add(tttButtonPanel);

        defaultJFrame.add(container);

        defaultJFrame.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rpslsButton){
            com.RPSLS.game.Game.runGame();
            defaultJFrame.setVisible(false);

        }
        if(e.getSource() == tttButton){
            defaultJFrame.setVisible(false);
            com.TTT.game.Game.runGame();

        }
    }
}