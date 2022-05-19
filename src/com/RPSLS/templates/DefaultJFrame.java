package com.RPSLS.templates;

import javax.swing.*;
import java.awt.*;

public class DefaultJFrame extends JFrame {

    public DefaultJFrame(int row, int col){
        TopMenu menu = new TopMenu();

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu.fileMenu);
        menuBar.add(menu.soundMenu);
        menuBar.add(menu.helpMenu);

        ImageIcon titleImg = new ImageIcon("img/game_center_banner.png");
        JLabel titleImgLabel = new JLabel();
        titleImgLabel.setIcon(titleImg);

        JPanelBlack title = new JPanelBlack();
        title.add(titleImgLabel);

        this.setJMenuBar(menuBar);
        this.setTitle("Game Center");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(2300,1500);
        this.setLayout(new GridLayout(row,col));
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);
        this.add(title);
    }

    public DefaultJFrame(String filename, int row, int col, String title){
        TopMenu menu = new TopMenu();

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu.fileMenu);
        menuBar.add(menu.soundMenu);
        menuBar.add(menu.helpMenu);

        ImageIcon titleImg = new ImageIcon(filename);
        JLabel titleImgLabel = new JLabel();
        titleImgLabel.setIcon(titleImg);

        JPanelBlack titleImgPanel = new JPanelBlack();
        titleImgPanel.add(titleImgLabel);

        this.setJMenuBar(menuBar);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(2300,1500);
        this.setLayout(new GridLayout(row,col));
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);
        this.add(titleImgPanel);
    }
}