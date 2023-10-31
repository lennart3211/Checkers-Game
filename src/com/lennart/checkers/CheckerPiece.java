package com.lennart.checkers;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class CheckerPiece extends JButton {
    private int row;
    private int col;
    private Color color;
    private boolean hasPiece;
    private boolean player;

    public CheckerPiece(int row, int column, Color color) {
        this.row = row;
        this.col = column;
        this.color = color;
        setPreferredSize(new Dimension(100, 100));
        setBackground(this.color);
        setOpaque(true);
        setBorderPainted(false);
    }

    public boolean getPlayer() {
        return player;
    }

    public boolean hasPiece() {
        return hasPiece;
    }

    public void setPiece(boolean hasPiece, boolean player) {
        this.hasPiece = hasPiece;
        if (player) {
            setBackground(Color.decode("#cc241d"));
        } else {
            setBackground(Color.decode("#458588"));
        }
    }
}
