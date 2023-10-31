package com.lennart.checkers;

public class CheckersGame {
    private static GameWindow gameWindow;
    private static CheckerSquare selectedPiece;
    private static boolean currPlayer = false;

    /** Constructor */
    public CheckersGame() {
        gameWindow = new GameWindow();
    }

    public static void startNewGame() {
        currPlayer = false;
        gameWindow = new GameWindow();
    }

    /**
     * Handles a square being clicked
     * @param row - row of square clicked
     * @param col - column of square clicked
     */
    public static void onCheckerPieceClicked(int row, int col) {

        // The piece the user just clicked on
        CheckerSquare clickedSquare = gameWindow.getCheckerBoard().getPiece(row, col);

        // Checks if the clicked piece is from the user
        if (clickedSquare.hasPiece() && isTurn(clickedSquare.getPlayer())) {
            System.out.println("selected");

            // Selects piece to be moved
            selectedPiece = clickedSquare;
        }
        
        // If a piece is already selected, checks if it's a valid move
        else if (selectedPiece != null && isValidMove(clickedSquare)) {
            System.out.println("moved");

            // removes piece from the selected piece
            selectedPiece.removePiece();

            // moves piece to new square
            clickedSquare.setPiece(currPlayer);

            if ((clickedSquare.getRow() == 8 && clickedSquare.getPlayer()) || (clickedSquare.getRow() == 0 && !clickedSquare.getPlayer())) {
                System.out.println("King");
                clickedSquare.makeKing();
            }

            // change turn
            currPlayer = !currPlayer;

            // change turn message
            if (currPlayer)
                gameWindow.geStatusBar().setStatus("Player 2's turn");
            else 
                gameWindow.geStatusBar().setStatus("Player 1's turn");
        } else {
            System.out.println("invalid");
            selectedPiece = new CheckerSquare(-1, -1, null);
        }
    }

    private static boolean isTurn(boolean player) {
        return player == currPlayer;
    }

    /**
     * Checks if move is valid
     * @param square - The clicked square
     * @return
     */
    private static boolean isValidMove(CheckerSquare square) {
        int row = selectedPiece.getRow();
        int col = selectedPiece.getCol();
        int newRow = square.getRow();
        int newCol = square.getCol();

        int rowDistance = newRow - row;
        int colDistance = newCol - col;

        if (square.hasPiece()) {
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
            CheckerSquare pieceInTheMiddle = gameWindow.getCheckerBoard().getPiece(middleRow, middleCol);
            if (pieceInTheMiddle == null || pieceInTheMiddle.getPlayer() == selectedPiece.getPlayer()) {
                return false;
            }
            pieceInTheMiddle.removePiece();
            if (gameWindow.getCheckerBoard().hasWon(currPlayer)) {
                String playerName = currPlayer ? "Player 1" : "Player 2";
                GameOverDialog.displayGameOverMessage(playerName);
            }
        }

        // Check if the move for the piece is moving forward, or any direction if it's a king
        if (selectedPiece.isKing()
                || (selectedPiece.getPlayer() && rowDistance > 0)
                || (!selectedPiece.getPlayer() && rowDistance < 0)
        ) {
            return true;
        }

        return false;
    }
}
