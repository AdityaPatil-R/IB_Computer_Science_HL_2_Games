import java.awt.Color;
import java.awt.Graphics;

public class Ornament {
    private int xPosition, yPosition, radius, speed;
    private Color color;

    public Ornament() {
        radius = 10 + (int) (Math.random() * 5);
        speed = (int) (radius / 2.5);
        xPosition = radius + (int) (Math.random() * (1000 - (2 * radius)));
        yPosition = 0;
        color = generateColor();
    }

    public void updateOrnamentFall() {
        yPosition += speed;

        if (yPosition > 630 + radius) {
            xPosition = radius + (int) (Math.random() * (1000 - (2 * radius)));
            yPosition = 0;
        }
    }

    public void drawOrnament(Graphics g) {
        g.setColor(color);
        g.fillOval(xPosition - radius, yPosition - radius, 2 * radius, 2 * radius);
    }

    public static Color generateColor() {
        Color[] colors = new Color[] { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.PINK };
        return colors[(int) (Math.random() * 8)];
    }

    public void setOrnamentSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public int getOrnamentSpeed() {
        return speed;
    }

    public int getOrnamentRadius() {
        return radius;
    }

    public int getOrnamentXPosition() {
        return xPosition;
    }

    public int getOrnamentYPosition() {
        return yPosition;
    }
}