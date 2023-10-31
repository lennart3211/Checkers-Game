package com.lennart.checkers;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * Represents the checker board
 */
public class CheckerBoard extends JPanel {

    public static final int SIZE = 8;
    private CheckerSquare[][] board;

    public CheckerBoard() {
        this.setLayout(new GridLayout(SIZE, SIZE));
        this.setPreferredSize(new Dimension(800, 800));
        board = new CheckerSquare[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                CheckerSquare piece;
                if (i % 2 == j % 2) {
                    piece = new CheckerSquare(i,j, CheckerColors.BOARD_COLOR_2);
                } else {
                    piece = new CheckerSquare(i,j, CheckerColors.BOARD_COLOR_1);
                }
                board[i][j] = piece;
                this.add(piece);
            }
        }

        setupCheckerPieces();
    }

    private void setupCheckerPieces() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i % 2 != j % 2) {
                    board[i][j].setPiece(true);
                } 
            }
        }

        for (int i = SIZE - 3; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i % 2 != j % 2) {
                    board[i][j].setPiece(false);
                }
            }
        }
    }

    public CheckerSquare getPiece(int row, int col) {
        return board[row][col];
    }

    public boolean hasWon(boolean player) {
        if (!player) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j].getPlayer()) {
                        return false;
                    }
                }
            }
        } else {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (!board[i][j].getPlayer()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
