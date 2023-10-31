package com.lennart.checkers;

import javax.swing.SwingUtilities;

public class CheckersGame {
    private GameWindow gameWindow;
    private CheckerPiece selectedPiece;
    private boolean currPlayer;

    public CheckersGame() {
        gameWindow = new GameWindow();
    }

    public void onCheckerPieceClicked(int row, int col) {
        CheckerPiece clickedPiece = gameWindow.getCheckerBoard().getPiece(row, col);

        if (clickedPiece.hasPiece() && isTurn(clickedPiece.getPlayer())) {
            this.selectedPiece = clickedPiece;
        } else if (selectedPiece != null && isValidMove(selectedPiece, row, col)) {

        }
    }

    private boolean isTurn(boolean player) {
        return player == currPlayer;
    }

    private boolean isValidMove(CheckerPiece piece, int row, int col) {
        return true;
    }
}
