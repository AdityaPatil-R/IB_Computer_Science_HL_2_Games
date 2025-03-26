import java.awt.*;
import javax.swing.*;

class Main extends JPanel {
    public static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Summer Break Game");
        frame.setLayout(new BorderLayout());
        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        new Buttons();

        frame.getContentPane().add(new Background());
        frame.setVisible(true);
    }
}