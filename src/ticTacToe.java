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

    }
    //situation where X wins(going to receive winning combination of buttons basically)
    public void xWins(int a, int b)
    {

    }
    //situation where O wins(going to receive winning combination of buttons basically)
    public void yWins(int a, int b)
    {

    }
}
