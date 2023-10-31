package com.lennart.checkers;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 * represents a single square on the checker board
 */
public class CheckerSquare extends JButton {

    private int row;
    private int col;
    private Color color;
    private boolean hasPiece;
    private boolean isKing;
    private boolean player;

    public CheckerSquare(int row, int column, Color color) {
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
            setBackground(CheckerColors.PIECE_COLOR_2);
        } else {
            setBackground(CheckerColors.PIECE_COLOR_1);
        }
    }

    public void removePiece() {
        hasPiece = false;
        setBackground(CheckerColors.BOARD_COLOR_1);
    }

    public boolean isKing() {
        return isKing;
    }

    public void makeKing() {
        isKing = true;
    }
}
