package com.RPSLS.templates;

import javax.swing.*;
import java.awt.*;

public class DefaultTextArea extends JTextArea {
    public DefaultTextArea(String text){
        this.setText(text);
        this.setForeground(Color.white);
        this.setBackground(Color.black);
        this.setFont(new Font("Interstate", Font.BOLD, 26 ));
        this.setEditable(false);
    }
    public DefaultTextArea(String text, int size){
        this.setText(text);
        this.setForeground(Color.white);
        this.setBackground(Color.black);
        this.setFont(new Font("Interstate", Font.BOLD, size ));
        this.setEditable(false);
    }
}