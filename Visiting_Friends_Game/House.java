import java.awt.Color;
import java.awt.Graphics;

public class House {
    private int xCenter, yCenter;
    private Color color;
    private String name;
    public static Color[] colors = new Color[] { Color.RED, Color.ORANGE, Color.YELLOW, Color.CYAN, Color.BLUE, Color.MAGENTA };
    public static String[] names = new String[] { "Aniket", "Diego", "Aditya", "Ryan", "Chastain", "Jackson", "Van", "Colby", "Justin", "Leo", "Michael", "Sri", "Chung", "Suvan", "Daniel", "Jennica", "Bhavanbir", "Adam", "Dylan", "Alec", "Ayush", "Ken", "Michael", "Christian", "Shant" };

    public House() {
        xCenter = 20 + (int) (Math.random() * 840);
        yCenter = 280 + 20 + (int) (Math.random() * 315);
        color = colors[(int) (Math.random() * colors.length)];
        name = names[(int) (Math.random() * names.length)];
    }

    public void drawHouse(Graphics g) {
        g.setColor(color);
        g.fillRect(xCenter - 10, yCenter - 10, 20, 20);

        g.setColor(new Color(150, 75, 0));
        g.fillPolygon(new int[] { xCenter - 15, xCenter, xCenter + 15 }, new int[] { yCenter - 10, yCenter - 20, yCenter - 10 }, 3);
        g.fillRect(xCenter - 3, yCenter, 6, 10);

        g.setColor(Color.WHITE);
        g.fillOval(xCenter - 1, yCenter + 3, 3, 3);

        g.setColor(Color.BLACK);
        g.drawString(name, xCenter - 15, yCenter - 20);
    }

    public void generateNewLocation() {
        xCenter = 20 + (int) (Math.random() * 840);
        yCenter = 20 + (int) (Math.random() * 595);
    }

    public static String generateName(int index) {
        return names[index];
    }

    public void setName(String name) {
        this.name = name;
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

    public String StringColor() {
        if (this.color == Color.RED) {
            return "Red";
        }

        if (this.color == Color.ORANGE) {
            return "Orange";
        }

        if (this.color == Color.YELLOW) {
            return "Yellow";
        }

        if (this.color == Color.CYAN) {
            return "Cyan";
        }

        if (this.color == Color.BLUE) {
            return "Blue";
        }

        if (this.color == Color.MAGENTA) {
            return "Magenta";
        }

        return "";
    }

    public String name() {
        return name;
    }

    public String toString() {
        return "Color: " + StringColor() + ", Location: (" + X() + ", " + Y() + "), and Owner: " + name();
    }
}