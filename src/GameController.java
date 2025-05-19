import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameController {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameBoard board;
    private JLabel textField;

    public GameController(Player player1, Player player2, GameBoard board,  JLabel status)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.textField = status;
    }
    public void firstTurn()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        if(random.nextInt(2) == 0) {
            currentPlayer = player1;

        }
            else {
            currentPlayer = player2;
        }
            updateStatus();
    }
    private void updateStatus() {
        textField.setText("<html>" + currentPlayer.getName() + "'s Turn<br>" +
                player1.getName() + ": " + player1.getScore() + " | " +
                player2.getName() + ": " + player2.getScore() + "</html>");
    }

    public void Move(int index)
    {
        JButton[] buttons = board.getButtons();
        if(buttons[index].getText().equals(""))
        {
            buttons[index].setForeground(currentPlayer == player1 ? Color.red : Color.yellow);
            buttons[index].setText(currentPlayer.getSymbol());

          //  textField.setText(player1.getName() + ": " + player1.getScore() + player2.getName()+": " + player2.getScore());

            if(board.checkWin(currentPlayer.getSymbol()))
            {
                currentPlayer.incrementScore();
                int[] win = new int[3];
                win = board.getWinningPattern();
                for(int i : win)
                {
                    buttons[i].setBackground(Color.green);
                }
                for(JButton button : buttons)
                {
                    button.setEnabled(false);
                }
                textField.setText("<html>" + currentPlayer.getName() + " wins!<br>Score: " +
                        player1.getName() + ": " + player1.getScore() + " | " +
                        player2.getName() + ": " + player2.getScore() + "</html>");

                return;
            }
            if(board.isDraw())
            {
                textField.setText("<html>Draw!<br>Score: " +
                        player1.getName() + ": " + player1.getScore() + " | " +
                        player2.getName() + ": " + player2.getScore() + "</html>");
                return;
            }
            switchPlayer();
            updateStatus();
        }
    }
    public void switchPlayer()
    {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;

    }

    public void resetGame()
    {
        board.resetBoard();
        firstTurn();
    }
}
