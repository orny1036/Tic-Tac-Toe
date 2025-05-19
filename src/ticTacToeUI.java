import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ticTacToeUI implements ActionListener {

   // Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton restartButton = new JButton("Restart");
    JButton exitButton = new JButton("Exit");

    GameBoard gameBoard;
    GameController controller;

    public ticTacToeUI() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(0, 0, 0));
        textField.setForeground(Color.CYAN);
        textField.setFont(new Font("Ink Free", Font.BOLD, 45));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(100, 100, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        bottomPanel.setLayout(new FlowLayout());

        for (int i = 0; i < 9; ++i) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 70));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        restartButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        exitButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        restartButton.setBackground(Color.cyan);
        exitButton.setBackground(Color.red);
        restartButton.setFocusable(false);
        exitButton.setFocusable(false);
        restartButton.addActionListener(this);
        exitButton.addActionListener(this);

        bottomPanel.add(restartButton);
        bottomPanel.add(exitButton);

        frame.add(bottomPanel, BorderLayout.SOUTH);
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        //firstTurn();
        Player p1 = new Player("Hania","X");
        Player p2 = new Player("Ahad","O");
        gameBoard = new GameBoard(buttons);
        controller = new GameController(p1,p2,gameBoard,textField);
        controller.firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; ++i) {
            if (e.getSource() == buttons[i]) {
                controller.Move(i);
                return;
            }
        }
        if (e.getSource() == restartButton) {
           controller.resetGame();
        } else if (e.getSource() == exitButton) {
            int choice = JOptionPane.showConfirmDialog(frame, "Exit the game?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
