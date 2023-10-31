package com.lennart.checkers;

import javax.swing.JOptionPane;

public class GameOverDialog extends JOptionPane {
    private static final String GAME_OVER_MESSAGE_TEMPLATE = "Game Over! The winner is %s!";

    public static void displayGameOverMessage(String winnerName) {
        showMessageDialog(null, String.format(GAME_OVER_MESSAGE_TEMPLATE, winnerName));
    }
}
