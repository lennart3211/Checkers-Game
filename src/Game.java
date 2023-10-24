import javax.swing.*;
import java.awt.*;

public class Game 
{
    private GameWindow window;
    private boolean isSelected = false;
    private int selectedSquare = -1;
    private boolean currPlayer = true;

    private Color boardColor1 = Color.decode("#282828");
    private Color boardColor2 = Color.decode("#ebdbb2");
    private Color pieceColor1 = Color.decode("#cc241d");
    private Color pieceColor2 = Color.decode("#458588");

    public Game() 
    {
        window = new GameWindow(this);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        for (int i = 0; i < 8; i+= 2) {
            window.setButtonColor(i, pieceColor1);
        }
        for (int i = 1; i < 8; i+= 2) {
            window.setButtonColor(i + 8, pieceColor1);
        }

        for (int i = 0; i < 8; i+= 2) {
            window.setButtonColor(i + 48, pieceColor2);
        }
        for (int i = 1; i < 8; i+= 2) {
            window.setButtonColor(i + 56, pieceColor2);
        }
        
    }

    public void buttonClicked(int i) 
    {
        if (((i / 8) % 2 == 0 && i % 2 != 0) || ((i / 8) % 2 != 0 && i % 2 == 0)) 
            return;
        
        Color c = window.getButtonColor(i);
        
        if (c.equals(currPlayer ? pieceColor1 : pieceColor2) && !isSelected)
        {
            selectedSquare = i;
            isSelected = true;
        } else if(isSelected){
            if (currPlayer)
                if (movePieceP1(i)) currPlayer = !currPlayer;
            else    
                if (movePieceP2(i)) currPlayer = !currPlayer;
                
           isSelected = false;
        }
    }

    private boolean movePieceP2(int i) {
        System.out.println(i);
        switch(selectedSquare - i) {
            case 7:
            case 9:
                window.setButtonColor(selectedSquare, Color.decode("#ffffff"));
                window.setButtonColor(i, pieceColor2);
                return true;
            default:
                return false;
        }        
    }
    private boolean movePieceP1(int i) {
        switch(i - selectedSquare) {
            case 7:
            case 9:
                window.setButtonColor(selectedSquare, Color.decode("#ffffff"));
                window.setButtonColor(i, pieceColor1);
                return true;
            default:
                return false;
        }        
    }
}