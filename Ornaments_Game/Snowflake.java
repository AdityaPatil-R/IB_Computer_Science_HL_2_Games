import java.awt.Color;
import java.awt.Graphics;

public class Snowflake {
    private int xPosition, yPosition, radius, speed, typeOfSnowflake;

    public Snowflake() {
        radius = 5 + (int) (Math.random() * 5);
        speed = (int) (radius / 1.5);
        typeOfSnowflake = (int) (Math.random() * 2);
        xPosition = radius + (int) (Math.random() * (1000 - (2 * radius)));
        yPosition = 0;
    }

    public void updateSnowflakeFall() {
        yPosition += speed;

        if (yPosition > 630 + radius) {
            xPosition = radius + (int) (Math.random() * (1000 - (2 * radius)));
            yPosition = 0;
        }
    }

    public void drawSnowflake(Graphics g) {
        g.setColor(Color.WHITE);

        int longLeg = (int) (radius * Math.sqrt(3) / 2);
        int shortLeg = (int) (radius / 2);

        if (typeOfSnowflake == 0) {
            g.drawLine(xPosition, yPosition - radius, xPosition, yPosition + radius);
            g.drawLine(xPosition - longLeg, yPosition - shortLeg, xPosition + longLeg, yPosition + shortLeg);
            g.drawLine(xPosition + longLeg, yPosition - shortLeg, xPosition - longLeg, yPosition + shortLeg);
        } else {
            g.drawLine(xPosition - radius, yPosition, xPosition + radius, yPosition);
            g.drawLine(xPosition - shortLeg, yPosition - longLeg, xPosition + shortLeg, yPosition + longLeg);
            g.drawLine(xPosition - shortLeg, yPosition + longLeg, xPosition + shortLeg, yPosition - longLeg);
        }
    }

    public int getSnowflakeHeight() {
        return yPosition;
    }

    public int getSnowflakeRadius() {
        return radius;
    }

    public void setSnowflakeSpeed(int newSpeed) {
        speed = newSpeed;
    }
}