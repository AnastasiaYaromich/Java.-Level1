package TicTacToe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class GameWindow extends JFrame {
    private static final int WIN_HEIGHT = 570;
    private static final int WIN_WIDTH = 515;
    private static final int WIN_POS_X = 800;
    private static final int WIN_POS_Y = 300;

    private static Maps field;
    private static  StartNewGameWindow startNewGameWindow;

    public GameWindow() throws IOException {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WIN_POS_X, WIN_POS_Y, WIN_WIDTH, WIN_HEIGHT);
        setTitle("Tic-Tac-Toe Game");
        setResizable(false);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        JButton btnNewGame = new JButton("Start New Game");
        JButton btnExit = new JButton("Exit");

        startNewGameWindow = new StartNewGameWindow(this);

        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        field = new Maps();
        add(field, BorderLayout.CENTER);
        bottomPanel.add(btnNewGame);
        bottomPanel.add(btnExit);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        field.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }

}
