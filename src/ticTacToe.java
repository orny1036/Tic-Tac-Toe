import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ticTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton restartButton = new JButton("Restart");
    JButton exitButton = new JButton("Exit");

    Player player1 = new Player("Player 1", "X");
    Player player2 = new Player("Player 2", "O");
    Player currentPlayer;

    int xScore = 0;
    int oScore = 0;

    ticTacToe() {
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
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 70));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
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

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; ++i) {
            if (e.getSource() == buttons[i]) {
                if (buttons[i].getText().equals("")) {
                    buttons[i].setForeground(currentPlayer == player1 ? Color.red : Color.yellow);
                    buttons[i].setText(currentPlayer.getSymbol());
                    switchPlayer();
                    textField.setText("X: " + player1.getScore() + " O: " + player2.getScore());
                    check();
                }
            }
        }
        if (e.getSource() == restartButton) {
            resetGame();
        } else if (e.getSource() == exitButton) {
            int choice = JOptionPane.showConfirmDialog(frame, "Exit the game?", "Confirm Exit", JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            currentPlayer = player1;
            textField.setText("<html>Player 1's turn<br>Player 1: " + player1.getScore() + " | Player 2: " + player2.getScore() + "</html>");
        } else {
            currentPlayer = player2;
            textField.setText("<html>Player 2's turn<br>Player 1: " + player1.getScore() + " | Player 2: " + player2.getScore() + "</html>");
        }
    }

    public void check() {
        // Checking for X
        checkWin("X", player1);

        // Checking for O
        checkWin("O", player2);

        boolean draw = true;
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                draw = false;
                break;
            }
        }

        if (draw) {
            textField.setText("<html>Draw!<br>X: " + player1.getScore() + " O: " + player2.getScore() + "</html>");
        }
    }

        private void checkWin(String symbol, Player player) {
            // First row
            if((buttons[0].getText().equals(symbol)) && (buttons[1].getText().equals(symbol)) && (buttons[2].getText().equals(symbol))) {
                decideWinner(player, 0, 1, 2);
                return;
            }
            // Second row
            if((buttons[3].getText().equals(symbol)) && (buttons[4].getText().equals(symbol)) && (buttons[5].getText().equals(symbol))) {
                decideWinner(player, 3, 4, 5);
                return;
            }
            // Third row
            if((buttons[6].getText().equals(symbol)) && (buttons[7].getText().equals(symbol)) && (buttons[8].getText().equals(symbol))) {
                decideWinner(player, 6, 7, 8);
                return;
            }
            // First column
            if((buttons[0].getText().equals(symbol)) && (buttons[3].getText().equals(symbol)) && (buttons[6].getText().equals(symbol))) {
                decideWinner(player, 0, 3, 6);
                return;
            }
            // Second column
            if((buttons[1].getText().equals(symbol)) && (buttons[4].getText().equals(symbol)) && (buttons[7].getText().equals(symbol))) {
                decideWinner(player, 1, 4, 7);
                return;
            }
            // Third column
            if((buttons[2].getText().equals(symbol)) && (buttons[5].getText().equals(symbol)) && (buttons[8].getText().equals(symbol))) {
                decideWinner(player, 2, 5, 8);
                return;
            }
            // First diagonal
            if((buttons[0].getText().equals(symbol)) && (buttons[4].getText().equals(symbol)) && (buttons[8].getText().equals(symbol))) {
                decideWinner(player, 0, 4, 8);
                return;
            }
            // Second diagonal
            if((buttons[2].getText().equals(symbol)) && (buttons[4].getText().equals(symbol)) && (buttons[6].getText().equals(symbol))) {
                decideWinner(player, 2, 4, 6);
                return;
            }
        }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        textField.setText(currentPlayer.getName() + "'s turn");
    }

    public void decideWinner(Player winner, int a, int b, int c) {
        winner.incrementScore();
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (JButton button : buttons) {
            button.setEnabled(false);
        }

        textField.setText("<html>" + winner.getName() + " wins<br>Score - X: " + player1.getScore() + " | O: " + player2.getScore() + "</html>");
    }

    private void resetGame() {
        for (JButton button : buttons) {
            button.setText("");
            button.setEnabled(true);
            button.setBackground(null);
        }
        firstTurn();
    }
}
