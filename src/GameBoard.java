import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GameBoard {
    private JButton[] buttons;
    private final int[][] winningCombinations = {{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };
    private int[] winningPattern = new int[3];
    public GameBoard(JButton[] buttons)
    {
     this.buttons = buttons;
    }

    public void resetBoard()
    {
        for(JButton button : buttons)
        {
            button.setText("");
            button.setEnabled(true);
            button.setBackground(null);
        }
    }
    public boolean isDraw()
    {
        for(JButton button : buttons)
        {
            if(button.getText().equals(""))
                return false;
        }
        return true;
    }
    public boolean checkWin(String symbol)
    {

        for(int[] combo : winningCombinations)
        {
            if(buttons[combo[0]].getText().equals(symbol) &&
                    buttons[combo[1]].getText().equals(symbol) &&
                    buttons[combo[2]].getText().equals(symbol))
            {
                winningPattern[0] = combo[0];
                winningPattern[1] = combo[1];
                winningPattern[2] = combo[2];
                //markWinningCombo(combo);
                return true;
            }
        }
        return false;
    }
    private void markWinningCombo(int[]win)
    {
        for(int i : win)
        {
            buttons[i].setBackground(Color.green);
        }
        for(JButton button : buttons)
        {
            button.setEnabled(false);
        }
    }

    public JButton[] getButtons()
    {
        return buttons;
    }
    public int[] getWinningPattern()
    {
        return winningPattern;
    }


}
