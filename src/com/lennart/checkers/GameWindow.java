package com.lennart.checkers;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GameWindow extends JFrame { 
    
    private GameMenu gameMenu;
    private CheckerBoard checkerBoard;
    private StatusBar statusBar;

    public GameWindow() {
        gameMenu = new GameMenu();
        statusBar = new StatusBar();
        checkerBoard = new CheckerBoard();

        this.setJMenuBar(gameMenu);
        this.add(checkerBoard, BorderLayout.CENTER);
        this.add(statusBar, BorderLayout.PAGE_END);

        this.setTitle("Checkers Game");
        this.setSize(800, 800);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public CheckerBoard getCheckerBoard() {
        return checkerBoard;
    }

    public StatusBar geStatusBar() {
        return statusBar;
    }
}
