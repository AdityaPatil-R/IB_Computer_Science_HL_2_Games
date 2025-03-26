import java.awt.Color;
import java.awt.Graphics;

public class Egg {
    private int xCenter, yCenter;
    private Color color;
    public static Color[] colors = new Color[] { Color.RED, Color.ORANGE, Color.YELLOW, Color.CYAN, Color.BLUE, Color.MAGENTA };

    public Egg() {
        xCenter = 10 + (int) (Math.random() * 850);
        yCenter = 10 + (int) (Math.random() * 605);
        color = colors[(int) (Math.random() * colors.length)];
    }

    public void drawEgg(Graphics g) {
        g.setColor(color);
        g.fillOval(xCenter - 10, yCenter - 10, 20, 20);
    }

    public int X() {
        return xCenter;
    }

    public int Y() {
        return yCenter;
    }

    public Color Color() {
        return color;
    }

    public String toString() {
        return "Color: " + Color() + ", Location: (" + X() + ", " + Y() + "), and Point Value: " + Background.colorValues.get(Color()) + "\n";
    }
}