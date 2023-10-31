package com.lennart.checkers;

public class CheckersGame {
    private static GameWindow gameWindow;
    private static CheckerPiece selectedPiece;
    private static boolean currPlayer = false;

    /** Constructor */
    public CheckersGame() {
        gameWindow = new GameWindow();
    }

    /**
     * Handles a square being clicked
     * @param row - row of square clicked
     * @param col - column of square clicked
     */
    public static void onCheckerPieceClicked(int row, int col) {
        CheckerPiece clickedPiece = gameWindow.getCheckerBoard().getPiece(row, col);

        if (clickedPiece.hasPiece() && isTurn(clickedPiece.getPlayer())) {
            System.out.println("selected");
            selectedPiece = clickedPiece;
        } else if (selectedPiece != null && isValidMove(selectedPiece, row, col)) {
            System.out.println("moved");
            selectedPiece.removePiece();
            clickedPiece.setPiece(currPlayer);
            currPlayer = !currPlayer;
            if (currPlayer)
                gameWindow.geStatusBar().setStatus("Player 1's turn");
            else 
                gameWindow.geStatusBar().setStatus("Player 2's turn");
        } else {
            System.out.println("invalid");
            selectedPiece = new CheckerPiece(-1, -1, null);
        }
    }

    private static boolean isTurn(boolean player) {
        return player == currPlayer;
    }

    private static boolean isValidMove(CheckerPiece piece, int newRow, int newCol) {
        int row = piece.getRow();
        int col = piece.getCol();

        int rowDistance = newRow - row;
        int colDistance = newCol - col;

        if (gameWindow.getCheckerBoard().getPiece(newRow, newCol).hasPiece()) {
            return false;
        }

        // the piece can only move 1 or 2 squares, diagonally
        if (Math.abs(rowDistance) > 2 || Math.abs(colDistance) > 2 || Math.abs(rowDistance) != Math.abs(colDistance)) {
            return false;
        }

        // when moving 2 squares (jumping), there must be an opponent's piece in the middle square
        if (Math.abs(rowDistance) == 2) {
            int middleRow = row + rowDistance / 2;
            int middleCol = col + colDistance / 2;
            CheckerPiece pieceInTheMiddle = gameWindow.getCheckerBoard().getPiece(middleRow, middleCol);
            if (pieceInTheMiddle == null || pieceInTheMiddle.getPlayer() == piece.getPlayer()) {
                return false;
            }
            pieceInTheMiddle.removePiece();
        }

        // Check if the move for the piece is moving forward, or any direction if it's a king
        if (piece.isKing()
                || (piece.getPlayer() && rowDistance > 0)
                || (!piece.getPlayer() && rowDistance < 0)
        ) {
            return true;
        }

        return false;
    }
}
