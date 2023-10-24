import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame 
{
    private final int BOARD_SIZE = 64;
    private JButton[] squares = new JButton[BOARD_SIZE];

    public GameWindow() 
    {
        this.setSize(300, 300);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(8,8));

        for (int i = 0; i < BOARD_SIZE; i++) 
        {
            squares[i] = new JButton("test");
            container.add(squares[i]);
        }
    }
}   