package com.RPSLS.game;

import com.RPSLS.templates.DefaultJFrame;
import com.RPSLS.templates.DefaultTextArea;
import com.RPSLS.templates.JButtonHover;
import com.RPSLS.templates.JPanelBlack;
import com.game.client.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WelcomeScreen implements ActionListener {
    DefaultJFrame welcome;
    JButtonHover nextButton;

    WelcomeScreen (){
        welcome = new DefaultJFrame(3,1);

        JPanelBlack rules = new JPanelBlack();
        DefaultTextArea ruleText = new DefaultTextArea(Menu.displayRulesRPSLS());
        rules.add(ruleText);

        JPanelBlack textPositioning = new JPanelBlack();
        textPositioning.add(rules,BorderLayout.EAST);

        JPanelBlack bottomImage = new JPanelBlack();

        JLabel bottomLabel = new JLabel();
        ImageIcon rpslsImg = new ImageIcon("img/rockpaperscissor-2.png");
        bottomLabel.setIcon(rpslsImg);
        bottomImage.add(bottomLabel);

        JPanelBlack imgPositioning = new JPanelBlack();
        imgPositioning.add(bottomImage, BorderLayout.WEST);

        JPanelBlack column = new JPanelBlack();
        column.setLayout(new GridLayout(1,2));
        column.add(textPositioning);
        column.add(imgPositioning);

        JPanelBlack nextButtonPanel = new JPanelBlack();
        nextButton = new JButtonHover("Select Game Type", this);
        nextButtonPanel.add(nextButton);

        welcome.add(column);
        welcome.add(nextButtonPanel);
        welcome.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton){
            new ChooseGameType();
            welcome.setVisible(false);
        }
    }
}