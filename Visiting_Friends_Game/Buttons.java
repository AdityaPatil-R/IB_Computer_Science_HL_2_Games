import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Buttons extends JPanel implements ActionListener {
    private static JButton slowButton, mediumButton, fastButton, resetButton;
    public JPanel westPanel;

    public static int mode;
    public static double howGoodIsPlayer;

    public static boolean isGameOver;

    public Buttons() {
        mode = 0;
        isGameOver = false;

        westPanel = new JPanel(new GridLayout(4, 1));

        slowButton = new JButton("Slow");
        mediumButton = new JButton("Medium");
        fastButton = new JButton("Fast");
        resetButton = new JButton("Reset");

        slowButton.addActionListener(this);
        mediumButton.addActionListener(this);
        fastButton.addActionListener(this);
        resetButton.addActionListener(this);

        westPanel.add(slowButton);
        westPanel.add(mediumButton);
        westPanel.add(fastButton);
        westPanel.add(resetButton);

        Main.frame.add(westPanel, BorderLayout.WEST);
    }

    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();

        if (button == slowButton) {
            mode = 1;
        }

        if (button == mediumButton) {
            mode = 2;
        }

        if (button == fastButton) {
            mode = 3;
        }

        if (button == resetButton) {
            mode = 0;
            Background.resetGame();
        }
    }

    public static int gameMode() {
        return mode;
    }
}