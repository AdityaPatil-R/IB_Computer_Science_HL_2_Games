import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {
    public static JFrame winterGameFrame;

    public static void main(String args[]) {
        winterGameFrame = new JFrame("Aditya Patil's Winter Game");
        winterGameFrame.setLayout(new BorderLayout());
        winterGameFrame.setSize(1000, 750);
        winterGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winterGameFrame.setResizable(false);

        new WinterGameButtons();

        winterGameFrame.getContentPane().add(new Background());
        winterGameFrame.setVisible(true);
    }
}