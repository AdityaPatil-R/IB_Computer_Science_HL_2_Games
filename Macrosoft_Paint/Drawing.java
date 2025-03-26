import java.awt.*;
import java.awt.Graphics;

public class Drawing {
    private int drawingType;
    public Rectangle drawingArea;
    private Color drawingColor;

    public Drawing(int type, Rectangle area, Color color) {
        drawingType = type;
        drawingArea = area;
        drawingColor = color;
    }

    public void draw(Graphics g) {
        g.setColor(drawingColor);

        if (drawingType < 2) {
            g.drawLine(drawingArea.x, drawingArea.y, drawingArea.width, drawingArea.height);
        }

        if (drawingType == 2) {
            g.drawRect(drawingArea.x, drawingArea.y, drawingArea.width, drawingArea.height);
        }

        if (drawingType == 3) {
            g.drawOval(drawingArea.x, drawingArea.y, drawingArea.width, drawingArea.height);
        }

        if (drawingType == 4) {
            g.fillOval(drawingArea.x - 50, drawingArea.y - 50, drawingArea.width + 50, drawingArea.height + 50);
        }
    }
}