package com.lennart.checkers;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
    private JLabel statusLabel;

    public StatusBar() {
        this.setLayout(new BorderLayout());
        statusLabel = new JLabel("Ready");
        this.add(statusLabel, BorderLayout.WEST);
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }
}
