import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Buttons extends JPanel implements ActionListener {
    private static JButton easyModeButton, mediumModeButton, hardModeButton, endGameButton;
    public JPanel westPanel;

    public static String evaulationComment;
    public static String orderComment;

    public static int mode;
    public static double howGoodIsPlayer;

    public static boolean isGameOver;

    public Buttons() {
        evaulationComment = "";
        orderComment = "";
        mode = 0;
        isGameOver = false;

        westPanel = new JPanel(new GridLayout(4, 1));

        easyModeButton = new JButton("Easy Mode");
        mediumModeButton = new JButton("Medium Mode");
        hardModeButton = new JButton("Hard Mode");
        endGameButton = new JButton("End Game");

        easyModeButton.addActionListener(this);
        mediumModeButton.addActionListener(this);
        hardModeButton.addActionListener(this);
        endGameButton.addActionListener(this);

        westPanel.add(easyModeButton);
        westPanel.add(mediumModeButton);
        westPanel.add(hardModeButton);
        westPanel.add(endGameButton);

        Main.frame.add(westPanel, BorderLayout.WEST);
    }

    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();

        if (!isGameOver) {
            if (button == easyModeButton) {
                mode = 1;
            }

            if (button == mediumModeButton) {
                mode = 2;
            }

            if (button == hardModeButton) {
                mode = 3;
            }
        }

        if (button == endGameButton) {
            mode = 0;
            isGameOver = true;

            howGoodIsPlayer = (int) (10 * Background.playerEval / (Background.playerEval + Background.bunnyEval));

            evaulationComment = "";

            if (howGoodIsPlayer < 3) {
                evaulationComment = "Sorry, the bunny won. It got " + Background.bunnyEggs.size() + " eggs, and you only got " + Background.clickedEggs.size() + " eggs.";
            } else if (howGoodIsPlayer < 7) {
                evaulationComment = "You did around as good as the bunny. It got " + Background.bunnyEggs.size() + " eggs, and you got " + Background.clickedEggs.size() + " eggs.";
            } else {
                evaulationComment = "You have beaten the bunny! It only got " + Background.bunnyEggs.size() + " eggs, and you got " + Background.clickedEggs.size() + " eggs!";
            }

            for (Egg egg : Background.orderOfEggs) {
                orderComment += egg.toString();
            }
        }
    }

    public static int gameMode() {
        return mode;
    }
}