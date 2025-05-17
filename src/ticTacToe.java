import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ticTacToe implements ActionListener {
//To determine whose turn it's gonna be first randomly
    Random random = new Random();
   JFrame frame = new JFrame();
   //A panel to hold the title
   JPanel titlePanel = new JPanel();
  //A panel to hold al the buttons
    JPanel buttonPanel = new JPanel();
    //A panel to hold the restart button
    JPanel bottomPanel = new JPanel();
//To display messages or some sort
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton restartButton = new JButton("Restart");


    boolean player1_turn;
    int xScore = 0;
    int oScore = 0;

    ticTacToe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(0, 0, 0));
        textField.setForeground(Color.CYAN);
        textField.setFont(new Font("Ink Free",Font.BOLD,45));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(100,100,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
//Added buttons in the button panel grid layout
        for(int i = 0; i<9; ++i)
        {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,70));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        //Set up the Restart button
        restartButton.setFont(new Font("Arial",Font.BOLD,30));
        restartButton.setFocusable(false);
        restartButton.addActionListener(e->resetGame());

        //Add restart button to the bottom panel
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(restartButton);

        frame.add(bottomPanel,BorderLayout.SOUTH);
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i = 0; i<9; ++i)
       {
           if(e.getSource() == buttons[i])
           {
               if(player1_turn)
               {
                   if(buttons[i].getText() == "")
                   {
                       buttons[i].setForeground(Color.red);
                       buttons[i].setText("X");
                       player1_turn = false;
                       //Updated to show score in turn me ssage
                      // textField.setText("O turn \n X: " + xScore + " O: " + oScore);
                       textField.setText("<html>O turn<br>X: " + xScore + " O: " + oScore + "</html>");

                       // check();
                   }
               }
               else
               {
                   if(buttons[i].getText()=="")
                   {
                       buttons[i].setForeground(Color.yellow);
                       buttons[i].setText("O");
                       player1_turn = true;
                     //  textField.setText("X turn \n X: " + xScore + " O: " + oScore);
                       textField.setText("<html>X turn<br>X: " + xScore + " O: " + oScore + "</html>");

                       // check();
                   }
               }
               check();
           }
       }
    }
    //determine whose turn would be first(random)
    public void firstTurn() {
        //To show the title for 2 secs before assigning the player's turn.
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        //generate a random number between o and 1. If it's 0 then its the first player's turn and if its 1 then the second player's turn
        if(random.nextInt(2) == 0)
        {
            player1_turn = true;
            //to show message for X's turn
            //textField.setText("X turn | X: " + xScore + "  O: " + oScore);
            textField.setText("<html>X turn<br>X: " + xScore + " O: " + oScore + "</html>");

        }
        else
        {
            player1_turn = false;
          //  textField.setText("O turn | X: " + xScore + "  O: " + oScore);
            textField.setText("<html>O turn<br>X: " + xScore + " O: " + oScore + "</html>");

        }
    }
    //checking winning condition
    public void check()
    {
        //Covert buttons to a 3x3 string board for readability
        String[][] board = new String[3][3];
        int index = 0;
        for(int i = 0; i<3; i++)
        {
           for(int j = 0; j<3; ++j)
           {
               board[i][j] = buttons[index].getText();
               index++;
           }
        }
        //for checking X
        //first row
        if((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X"))
            {
                xWins(0,1,2);
            }
        //second row
        if((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X"))
        {
            xWins(3,4,5);
        }
        //third row
        if((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X"))
        {
            xWins(6,7,8);
        }
        //first column
        if((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X"))
        {
            xWins(0,3,6);
        }
        //second column
        if((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X"))
        {
            xWins(1,4,7);
        }
        //third column
        if((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X"))
        {
            xWins(2,5,8);
        }
        //first corner
        if((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X"))
        {
            xWins(0,4,8);
        }
        //second corner
        if((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X"))
        {
            xWins(2,4,6);
        }

        //for checking X
        //first row
        if((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O"))
        {
            oWins(0,1,2);
        }
        //second row
        if((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O"))
        {
            oWins(3,4,5);
        }
        //third row
        if((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O"))
        {
            oWins(6,7,8);
        }
        //first column
        if((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O"))
        {
            oWins(0,3,6);
        }
        //second column
        if((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O"))
        {
            oWins(1,4,7);
        }
        //third column
        if((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O"))
        {
            oWins(2,5,8);
        }
        //first corner
        if((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O"))
        {
            oWins(0,4,8);
        }
        //second corner
        if((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O"))
        {
            oWins(2,4,6);
        }

        boolean draw = true;
        for(JButton button : buttons)
        {
            if(button.getText() == "")
            {
                draw = false;
                break;
            }
        }

        if(draw)
        {
            textField.setText("<html>Draw!<br>X: " + xScore + "  O: " + oScore + "</html>");
        }
    }
    //situation where X wins(going to receive winning combination of buttons basically)
    public void xWins(int a, int b, int c)
    {
        xScore++;
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        endGame("X wins");
    }
    //situation where O wins(going to receive winning combination of buttons basically)
    public void oWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        endGame("O wins");
    }
    private void endGame(String message)
    {
        for(JButton button : buttons)
        {
            button.setEnabled(false);
        }
        textField.setText("<html>" + message + "<br>" + " X: " + xScore + " O: " + oScore + "</html>");
    }
    private void resetGame()
    {
        for(JButton button : buttons)
        {
            button.setText("");
            button.setEnabled(true);
            button.setBackground(null);
        }
        firstTurn();
    }


}
