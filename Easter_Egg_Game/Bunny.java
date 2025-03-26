import java.awt.Color;
import java.awt.Graphics;

public class Bunny {
    private int xSpeed, ySpeed, xCenter, yCenter;

    public Bunny() {
        xSpeed = 0;
        ySpeed = 0;
        xCenter = 425;
        yCenter = 303;
    }

    public void drawBunny(Graphics g) {
        g.setColor(Color.PINK);
        g.fillOval(xCenter - 15, yCenter - 15, 30, 35);
        g.fillOval(xCenter + 5, yCenter - 30, 15, 25);
        g.fillOval(xCenter - 20, yCenter - 30, 15, 25);

        g.setColor(Color.BLACK);
        g.fillOval(xCenter + 3, yCenter - 5, 5, 5);
        g.fillOval(xCenter - 8, yCenter - 5, 5, 5);
    }

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setXCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public void setYCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public int X() {
        return xCenter;
    }

    public int Y() {
        return yCenter;
    }

    public int xSpeed() {
        return xSpeed;
    }

    public int ySpeed() {
        return ySpeed;
    }
}