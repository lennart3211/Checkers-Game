package com.lennart.checkers;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameMenu extends JMenuBar {
    private JMenu gameMenu;
    private JMenuItem newGameItem;
    private JMenuItem exitItem;

    public GameMenu() {
        gameMenu = new JMenu("Game");
        
        newGameItem = new JMenuItem("New Game");
        exitItem = new JMenuItem("Exit");

        gameMenu.add(newGameItem);
        gameMenu.add(exitItem);

        this.add(gameMenu);
    }

    public JMenuItem getNewGameItem() {
        return newGameItem;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }
}
