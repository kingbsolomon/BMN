package com.TTT.game;

import com.RPSLS.templates.TopMenu;
import com.TTT.templates.DJFSettings;
import com.TTT.templates.JBTemplate;
import com.TTT.templates.JPanelBoard;
import com.TTT.templates.JTextTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTGame implements ActionListener{

    int playerNum;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    ImageIcon imgXScaled;
    ImageIcon imgOScaled;
    DJFSettings jFrameSettings;
    JTextTemplate text;

    public TTTGame(int playerNum) {

        this.playerNum = playerNum;

        jFrameSettings = new DJFSettings();
        TopMenu menu = new TopMenu();

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu.fileMenu);
        menuBar.add(menu.soundMenu);
        menuBar.add(menu.helpMenu);

        JPanel banner = new JPanel();
        banner.setBackground(Color.black);

        ImageIcon bannerIcon = new ImageIcon("img/game_center_banner.png");

        Image bannerIconResize = bannerIcon.getImage();
        Image scaledBannerIcon = bannerIconResize.getScaledInstance(1800,400, Image.SCALE_SMOOTH);

        ImageIcon newBannerIcon = new ImageIcon(scaledBannerIcon);

        JLabel label = new JLabel();
        label.setIcon(newBannerIcon);
        banner.add(label);

        text = new JTextTemplate();
        banner.add(text);

        JPanel banner2 = new JPanel();
        banner2.setLayout(new BorderLayout());
        banner2.setBackground(Color.red);

        JPanelBoard placeholder = new JPanelBoard();
        JPanelBoard placeholder2 = new JPanelBoard();
        JPanelBoard placeholder3 = new JPanelBoard();
        JPanelBoard placeholder4 = new JPanelBoard();

        JPanel layoutGameBoard = new JPanel();
        layoutGameBoard.setLayout(new GridLayout(3, 3));
        layoutGameBoard.setBackground(new Color(192,192,192));
        layoutGameBoard.setPreferredSize(new Dimension(300, 300));

        //x image
        ImageIcon imgX = new ImageIcon("img/x.png");
        imgXScaled = imgScale(imgX, 50,50);

        //O image
        ImageIcon imgO = new ImageIcon("img/o.png");
        imgOScaled = imgScale(imgO, 35,35);

        button1 = new JBTemplate(this);
        button2 = new JBTemplate(this);
        button3 = new JBTemplate(this);
        button4 = new JBTemplate(this);
        button5 = new JBTemplate(this);
        button6 = new JBTemplate(this);
        button7 = new JBTemplate(this);
        button8 = new JBTemplate(this);
        button9 = new JBTemplate(this);

        layoutGameBoard.add(button1);
        layoutGameBoard.add(button2);
        layoutGameBoard.add(button3);
        layoutGameBoard.add(button4);
        layoutGameBoard.add(button5);
        layoutGameBoard.add(button6);
        layoutGameBoard.add(button7);
        layoutGameBoard.add(button8);
        layoutGameBoard.add(button9);

        banner2.add(placeholder, BorderLayout.NORTH);
        banner2.add(placeholder2, BorderLayout.SOUTH);
        banner2.add(placeholder3, BorderLayout.EAST);
        banner2.add(placeholder4, BorderLayout.WEST);
        banner2.add(layoutGameBoard, BorderLayout.CENTER); //control the positioning
        jFrameSettings.setJMenuBar(menuBar);
        jFrameSettings.add(banner);
        jFrameSettings.add(banner2);
        jFrameSettings.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(playerNum == 1 ) {
         if(e.getSource() == button1){
             Game.gameArray2D[0][0] = 'X';
             disableSetIcon(button1, imgXScaled);
         }
         else if( e.getSource() == button2) {
             Game.gameArray2D[0][1] = 'X';
             disableSetIcon(button2, imgXScaled);
         }
         else if( e.getSource() == button3) {
             Game.gameArray2D[0][2] = 'X';
             disableSetIcon(button3, imgXScaled);
         }
         else if( e.getSource() == button4) {
             Game.gameArray2D[1][0] = 'X';
             disableSetIcon(button4, imgXScaled);
         }
         else if( e.getSource() == button5) {
             Game.gameArray2D[1][1] = 'X';
             disableSetIcon(button5, imgXScaled);
         }
         else if( e.getSource() == button6) {
             Game.gameArray2D[1][2] = 'X';
             disableSetIcon(button6, imgXScaled);
         }
         else if( e.getSource() == button7) {
             Game.gameArray2D[2][0] = 'X';
             disableSetIcon(button7, imgXScaled);
         }
         else if( e.getSource() == button8) {
             Game.gameArray2D[2][1] = 'X';
             disableSetIcon(button8, imgXScaled);
         }
         else if( e.getSource() == button9) {
             Game.gameArray2D[2][2] = 'X';
             disableSetIcon(button9, imgXScaled);
         }
         String winner = Game.determineWinner();
         if (winner != null) {
             text.setText(winner);
             disableAll();
             playAgain();
         }
            playerNum = 2;
     }

     else {
         if(e.getSource() == button1){
             Game.gameArray2D[0][0] = 'O';
             disableSetIcon(button1, imgOScaled);
         }
         else if( e.getSource() == button2) {
             Game.gameArray2D[0][1] = 'O';
             disableSetIcon(button2, imgOScaled);
         }
         else if( e.getSource() == button3) {
             Game.gameArray2D[0][2] = 'O';
             disableSetIcon(button3, imgOScaled);
         }
         else if( e.getSource() == button4) {
             Game.gameArray2D[1][0] = 'O';
             disableSetIcon(button4, imgOScaled);
         }
         else if( e.getSource() == button5) {
             Game.gameArray2D[1][1] = 'O';
             disableSetIcon(button5, imgOScaled);
         }
         else if( e.getSource() == button6) {
             Game.gameArray2D[1][2] = 'O';
             disableSetIcon(button6, imgOScaled);
         }
         else if( e.getSource() == button7) {
             Game.gameArray2D[2][0] = 'O';
             disableSetIcon(button7, imgOScaled);
         }
         else if( e.getSource() == button8) {
             Game.gameArray2D[2][1] = 'O';
             disableSetIcon(button8, imgOScaled);
         }
         else if( e.getSource() == button9) {
             Game.gameArray2D[2][2] = 'O';
             disableSetIcon(button9, imgOScaled);
         }
         String winner = Game.determineWinner();
         if (winner != null) {
             text.setText(winner);
             disableAll();
             playAgain();
         }
         playerNum = 1;
     }

    }
    private ImageIcon imgScale(ImageIcon icon,int width , int height) {
        Image charImg = icon.getImage();
        Image scaleImg = charImg.getScaledInstance(width,height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaleImg);
    }

    private void disableAll() {
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
    }

    private void disableSetIcon(JButton button, ImageIcon image) {
        button.setEnabled(false);
        button.setIcon(image);
    }

    private void playAgain() {
        int result = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Game Over!!!", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            Game.runGame();
            jFrameSettings.setVisible(false);
        }
    }
}