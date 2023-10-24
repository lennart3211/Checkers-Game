import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame 
{
    private final int BOARD_SIZE = 64;
    private JButton[] squares = new JButton[BOARD_SIZE];

    private Color boardColor1 = Color.decode("#282828");
    private Color boardColor2 = Color.decode("#ebdbb2");
    private Color pieceColor1 = Color.decode("#cc241d");
    private Color pieceColor2 = Color.decode("#458588");

    Game game;

    public GameWindow(Game game) 
    {
        this.game = game;
        this.setSize(800, 800);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(8,8));

        for (int i = 0; i < BOARD_SIZE; i++) 
        {
            squares[i] = new JButton("Button " + (i + 1));
            if (((i / 8) % 2 == 0 && i % 2 != 0) || ((i / 8) % 2 != 0 && i % 2 == 0)) 
            {
                squares[i].setBackground(boardColor1);
                squares[i].setForeground(boardColor1);
            }
            final int buttonIndex = i;
            squares[i].addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {game.buttonClicked(buttonIndex);}
            });
            
            container.add(squares[i]);
        }
    }

    public void setButtonColor(int i, Color color) {
        squares[i].setBackground(color);
    }

    public Color getButtonColor(int i) {
        return squares[i].getBackground();
    }

    public boolean isPlayersPiece(int i, boolean player) {
        if ((player && squares[i].getBackground().equals(pieceColor1)) || (!player && squares[i].getBackground().equals(pieceColor2))) {
            return true;
        }
        return false;
    }

}   