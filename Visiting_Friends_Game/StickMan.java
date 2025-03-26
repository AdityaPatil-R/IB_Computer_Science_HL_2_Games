import java.awt.Color;
import java.awt.Graphics;

public class StickMan {
    private int xSpeed, ySpeed, xCenter, yCenter;

    public StickMan() {
        xSpeed = 0;
        ySpeed = 0;
        xCenter = 425;
        yCenter = 303;
    }

    public void drawStickMan(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(xCenter - 5, yCenter - 20, 10, 10);
        g.drawLine(xCenter, yCenter - 10, xCenter, yCenter + 10);
        g.drawLine(xCenter, yCenter, xCenter - 10, yCenter - 10);
        g.drawLine(xCenter, yCenter, xCenter + 10, yCenter - 10);
        g.drawLine(xCenter, yCenter + 10, xCenter - 10, yCenter + 20);
        g.drawLine(xCenter, yCenter + 10, xCenter + 10, yCenter + 20);
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
