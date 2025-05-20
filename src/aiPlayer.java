import javax.swing.*;
import java.util.Random;

public class aiPlayer extends Player{
   //private int moves = 0;
    public aiPlayer(String name, String symbol)
    {
        super(name, symbol);
    }

    @Override
    public int makeMove(JButton[] buttons) {
        for(int i = 0; i<buttons.length; ++i)
        {
            if(buttons[i].getText().equals(""))
            {
                return i;
            }
        }
        return -1;
    }
}
