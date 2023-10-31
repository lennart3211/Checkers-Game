package com.lennart.checkers;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class CheckerBoard extends JPanel {
    public static final int SIZE = 8;
    public static final Color BOARD_COLOR_1 = Color.decode("#282828");
    public static final Color BOARD_COLOR_2 = Color.decode("#ebdbb2");
    public static final Color PIECE_COLOR_1 = Color.decode("#458588");
    public static final Color PIECE_COLOR_2 = Color.decode("#cc241d");
    private CheckerPiece[][] board;

    public CheckerBoard() {
        this.setLayout(new GridLayout(SIZE, SIZE));
        this.setPreferredSize(new Dimension(800, 800));
        board = new CheckerPiece[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                CheckerPiece piece;
                if (i % 2 == j % 2) {
                    piece = new CheckerPiece(i,j, BOARD_COLOR_2);
                } else {
                    piece = new CheckerPiece(i,j, BOARD_COLOR_1);
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
                    board[i][j].setPiece(true, PIECE_COLOR_1);
                } 
            }
        }

        for (int i = SIZE - 3; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i % 2 != j % 2) {
                    board[i][j].setPiece(true, PIECE_COLOR_2);
                }
            }
        }
    }
}
