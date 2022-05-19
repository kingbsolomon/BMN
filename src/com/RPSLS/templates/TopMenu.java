package com.RPSLS.templates;

import com.game.client.Menu;

import javax.swing.*;
import java.awt.*;

public class TopMenu extends JFrame {

    public JMenu fileMenu;
    public JMenu soundMenu;
    public JMenu helpMenu;

    public TopMenu(){
        fileMenu = new JMenu("File");
        soundMenu = new JMenu("Sound");
        helpMenu = new JMenu("Help");

        JMenuItem newRPSLS = new JMenuItem("RPSLS");
        newRPSLS.addActionListener(e -> {
           Window[] children = JFrame.getWindows();
            for (Window win : children) {
                    win.setVisible(false);
            }
            com.RPSLS.game.Game.runGame();
        });
        fileMenu.add(newRPSLS);

        JMenuItem newTTT = new JMenuItem("Tic Tac Toe");
        newTTT.addActionListener(e -> {
            Window[] children = JFrame.getWindows();
            for (Window win : children) {
                win.setVisible(false);
            }
            com.TTT.game.Game.runGame();
        });
        fileMenu.add(newTTT);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenuItem rules = new JMenuItem("Rules");
        String rulesString = Menu.displayRulesRPSLS() + Menu.displayRulesTicTacToe();
        rules.addActionListener(e -> JOptionPane.showMessageDialog(null, rulesString,
                "Rules", JOptionPane.INFORMATION_MESSAGE));
        helpMenu.add(rules);

        JMenuItem noSound = new JMenuItem("No Sound");
        noSound.addActionListener(e-> {
            try {
                Menu.audioStop();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        soundMenu.add(noSound);

        JMenuItem imperialMarch = new JMenuItem("Imperial March");
        String impURL = "https://www2.cs.uic.edu/~i101/SoundFiles/ImperialMarch60.wav";
        imperialMarch.addActionListener(e-> playMusic(impURL));
        soundMenu.add(imperialMarch);

        JMenuItem elephantWalk = new JMenuItem("Elephant Walk");
        String ewURL = "https://www2.cs.uic.edu/~i101/SoundFiles/BabyElephantWalk60.wav";
        elephantWalk.addActionListener(e-> playMusic(ewURL));
        soundMenu.add(elephantWalk);

        JMenuItem catinaBand = new JMenuItem("Catina Band");
        String cbURL = "https://www2.cs.uic.edu/~i101/SoundFiles/CantinaBand60.wav";
        catinaBand.addActionListener(e-> playMusic(cbURL));
        soundMenu.add(catinaBand);

    }

    private void playMusic(String url){
        try {
            Menu.playMusic(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}