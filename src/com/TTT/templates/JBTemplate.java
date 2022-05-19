package com.TTT.templates;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JBTemplate extends JButton {
    public JBTemplate(ActionListener e) {
        this.addActionListener(e);
    }
}