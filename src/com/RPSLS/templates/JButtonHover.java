package com.RPSLS.templates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JButtonHover extends JButton {

    public JButtonHover(String text, ActionListener actionListener){
        this.setText(text);
        this.setOpaque(true);
        this.addActionListener(actionListener);
        this.setFont(new Font("Interstate", Font.BOLD, 28 ));
        this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent event){
                setBackground(Color.decode("#FFE81F"));
            }
            public void mouseExited(MouseEvent event){
                setBackground(Color.black);
            }
        });
    }
}