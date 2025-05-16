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
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,30));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    //determine whose turn would be first(random)
    public void firstTurn()
    {

    }
    //checking winning condition
    public void check()
    {

    }
    //situation where X wins(going to receive winning combination of buttons basically)
    public void xWins(int a, int b)
    {

    }
    //situation where Y wins(going to receive winning combination of buttons basically)
    public void yWins(int a, int b)
    {

    }
}
