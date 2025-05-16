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
//To display messages or some sort
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    ticTacToe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(0, 0, 0));
        textField.setForeground(Color.CYAN);
        textField.setFont(new Font("Ink Free",Font.BOLD,55));
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
                       textField.setText("O turn");
                       check();
                   }
               }
               else
               {
                   if(buttons[i].getText()=="")
                   {
                       buttons[i].setForeground(Color.yellow);
                       buttons[i].setText("O");
                       player1_turn = true;
                       textField.setText("X turn");
                       check();
                   }
               }
           }
       }
    }
    //determine whose turn would be first(random)
    public void firstTurn() {
        //To show the title for 2 secs before assigning the player's turn.
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        //generate a random number between o and 1. If it's 0 then its the first player's turn and if its 1 then the second player's turn
        if(random.nextInt(2) == 0)
        {
            player1_turn = true;
            //to show message for X's turn
            textField.setText("X turn");
        }
        else
        {
            player1_turn = false;
            textField.setText("O turn");
        }
    }
    //checking winning condition
    public void check()
    {   
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
    }
    //situation where X wins(going to receive winning combination of buttons basically)
    public void xWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i = 0; i<9; ++i)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");
    }
    //situation where O wins(going to receive winning combination of buttons basically)
    public void oWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i = 0; i<9; ++i)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");
    }
}
