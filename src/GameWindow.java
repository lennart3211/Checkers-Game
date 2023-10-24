import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame 
{
    private final int BOARD_SIZE = 64;
    private JButton[] squares = new JButton[BOARD_SIZE];
    private Color boardColor1 = Color.decode("#282828");

    public GameWindow() 
    {
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
                public void actionPerformed(ActionEvent e) {buttonClicked(buttonIndex);}
            });
            
            container.add(squares[i]);
        }
    }

    private void buttonClicked(int buttonIndex) {
        
    }
}   