package com.TTT.templates;

import javax.swing.*;
import java.awt.*;

public class DJFSettings extends JFrame {

    public DJFSettings() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(2000, 1000);
        this.setVisible(true);
        this.setTitle("Tic-Tac-Toe");
        this.setLayout(new GridLayout(2, 1));
    }
}