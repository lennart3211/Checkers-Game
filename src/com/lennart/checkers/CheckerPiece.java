package com.lennart.checkers;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class CheckerPiece extends JButton {

    private int row;
    private int col;
    private Color color;
    private boolean hasPiece;
    private boolean isKing;
    private boolean player;

    public static final Color BOARD_COLOR_1 = Color.decode("#282828");
    public static final Color BOARD_COLOR_2 = Color.decode("#ebdbb2");
    public static final Color PIECE_COLOR_1 = Color.decode("#458588");
    public static final Color PIECE_COLOR_2 = Color.decode("#cc241d");

    public CheckerPiece(int row, int column, Color color) {
        this.row = row;
        this.col = column;
        this.color = color;
        setPreferredSize(new Dimension(100, 100));
        setBackground(this.color);
        setOpaque(true);
        setBorderPainted(false);

        this.addActionListener(e -> CheckersGame.onCheckerPieceClicked(row, column));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean getPlayer() {
        return player;
    }

    public boolean hasPiece() {
        return hasPiece;
    }

    public void setPiece(boolean player) {
        hasPiece = true;
        this.player = player;

        if (player) {
            setBackground(PIECE_COLOR_2);
        } else {
            setBackground(PIECE_COLOR_1);
        }
    }

    public void removePiece() {
        hasPiece = false;
        setBackground(BOARD_COLOR_1);
    }

    public boolean isKing() {
        return isKing;
    }
}
