import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WinterGameButtons extends JPanel implements ActionListener {
    private static JButton easyModeButton, mediumModeButton, hardModeButton, evaluateButton;
    public JPanel westPanel;

    public static String evaluationComment, additionalComment;

    public static int howGoodIsTree, whichMode;

    public static boolean endGame;

    public WinterGameButtons() {
        evaluationComment = "";
        additionalComment = "";
        whichMode = 1;
        endGame = false;

        westPanel = new JPanel(new GridLayout(4, 1));

        easyModeButton = new JButton("Easy Mode");
        mediumModeButton = new JButton("Medium Mode");
        hardModeButton = new JButton("Hard Mode");
        evaluateButton = new JButton("Evaulate Christmas Tree Decorations");

        easyModeButton.addActionListener(this);
        mediumModeButton.addActionListener(this);
        hardModeButton.addActionListener(this);
        evaluateButton.addActionListener(this);

        westPanel.add(easyModeButton);
        westPanel.add(mediumModeButton);
        westPanel.add(hardModeButton);
        westPanel.add(evaluateButton);

        Main.winterGameFrame.add(westPanel, BorderLayout.WEST);
    }

    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();

        if (button == easyModeButton) {
            whichMode = 1;
        }

        if (button == mediumModeButton) {
            whichMode = 2;
        }

        if (button == hardModeButton) {
            whichMode = 3;
        }

        if (button == evaluateButton) {
            endGame = true;

            for (Ornament ornament : Background.ornaments) {
                ornament.setOrnamentSpeed(0);
            }

            for (Snowflake snowflake : Background.snowflakes) {
                snowflake.setSnowflakeSpeed(0);
            }

            howGoodIsTree = (int) (10 * Background.clickedOrnaments.size() / 25);

            evaluationComment = "On a scale from 1 to 10, I rate your tree a " + howGoodIsTree + "!";

            if (howGoodIsTree < 3) {
                additionalComment = "I applaud the effort, you could've put more ornaments";
            } else if (howGoodIsTree < 7) {
                additionalComment = "Hey, that tree looks pretty good. Nice job!";
            } else {
                additionalComment = "Wow, that's an excellent tree! You sure got a lot of Christmas spirit!";
            }
        }
    }
}
