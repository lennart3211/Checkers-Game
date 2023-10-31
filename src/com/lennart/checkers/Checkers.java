package com.lennart.checkers;

import javax.swing.SwingUtilities;

public class Checkers {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GameWindow();
            }
        });
    }
    private static void startNewGame() {

    }

    private static void exitGame() {
        
    }
}
