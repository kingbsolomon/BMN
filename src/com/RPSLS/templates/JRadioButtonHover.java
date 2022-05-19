package com.RPSLS.templates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JRadioButtonHover extends JRadioButton {

    public JRadioButtonHover(ImageIcon img, ActionListener action){
        this.setForeground(Color.white);
        this.setBackground(Color.black);
        this.setOpaque(true);
        this.setIcon(img);
        this.addActionListener(action);
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