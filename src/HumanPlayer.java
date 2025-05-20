import javax.swing.*;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    public int makeMove(JButton[] buttons) {
        return -1;
    }


}
