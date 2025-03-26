import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Background extends JPanel implements ActionListener {
    private static int mouseX;
    private static int mouseY;

    private static int previousX;
    private static int previousY;

    public static int distanceTraveled;
    public static String orderComment;

    private Timer clock;

    private static LinkedList<House> notVisitedHouses;
    public static LinkedList<House> visitedHouses;

    public static HashMap<Color, Integer> yearsBuilt;

    public static Queue<House> orderOfHouses;
    public static LinkedList<House> temporaryOrder;

    private static StickMan stickMan;

    public Background() {
        clock = new Timer(10, this);

        notVisitedHouses = new LinkedList<House>();
        visitedHouses = new LinkedList<House>();

        stickMan = new StickMan();

        mouseX = 0;
        mouseY = 0;

        previousX = 425;
        previousY = 303;

        distanceTraveled = 0;
        orderComment = "";

        yearsBuilt = new HashMap<Color, Integer>();

        orderOfHouses = new LinkedList<House>();
        temporaryOrder = new LinkedList<House>();

        setPreferredSize(new Dimension(1000, 750));
        setBackground(new Color(144, 238, 144));

        for (int i = 0; i < 25; i++) {
            House house = new House();
            house.setName(House.generateName(i));
            notVisitedHouses.add(house);
        }

        for (int i = 0; i < House.colors.length; i++) {
            yearsBuilt.put(House.colors[i], (int) (Math.random() * (House.colors.length + 3)));
        }

        clock.start();
    }

    public static void resetGame() {
        notVisitedHouses = new LinkedList<House>();
        visitedHouses = new LinkedList<House>();

        stickMan = new StickMan();

        mouseX = 0;
        mouseY = 0;

        previousX = 425;
        previousY = 303;

        distanceTraveled = 0;
        orderComment = "";

        yearsBuilt = new HashMap<Color, Integer>();

        orderOfHouses = new LinkedList<House>();
        temporaryOrder = new LinkedList<House>();

        for (int i = 0; i < 25; i++) {
            notVisitedHouses.add(new House());
        }

        for (int i = 0; i < House.colors.length; i++) {
            yearsBuilt.put(House.colors[i], (int) (Math.random() * (House.colors.length + 3)));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        g.drawString("Welome to my travel simulator game!", 600, 50);
        g.drawString("Press one of the speed settings to visit the houses", 600, 75);
        g.drawString("See if you can predict the travel path!", 600, 100);
        g.drawString("Once it's done, the travel path will be shown", 600, 125);
        g.drawString("Press RESET to start anew", 600, 150);

        for (int i = 0; i < visitedHouses.size() - 1; i++) {
            if (i == 0) {
                g.drawLine(425, 303, visitedHouses.get(i).X(), visitedHouses.get(i).Y());
            }

            g.drawLine(visitedHouses.get(i).X(), visitedHouses.get(i).Y(), visitedHouses.get(i + 1).X(), visitedHouses.get(i + 1).Y());
        }

        for (House house : notVisitedHouses) {
            house.drawHouse(g);
        }

        for (House house : visitedHouses) {
            house.drawHouse(g);
        }

        stickMan.drawStickMan(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 625, 1000, 120);

        g.setColor(Color.BLACK);

        if (notVisitedHouses.size() == 0) {
            g.setColor(new Color(144, 238, 144));
            g.drawRect(0, 0, 1000, 1000);

            g.setColor(Color.BLACK);
            g.drawString("Your total distance traveled is " + distanceTraveled + " meters", 5, 640);

            g.drawString("1st House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 10);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("2nd House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 20);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("3rd House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 30);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("4th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 40);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("5th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 50);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("6th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 60);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("7th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 70);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("8th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 80);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("9th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 90);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("10th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 100);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("11th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 110);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("12th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 120);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("13th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 130);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("14th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 140);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("15th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 150);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("16th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 160);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("17th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 170);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("18th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 180);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("19th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 190);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("20th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 200);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("21st House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 210);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("22nd House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 220);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("23rd House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 230);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("24th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 240);
            orderOfHouses.remove(orderOfHouses.peek());
            g.drawString("25th House Visited - Color: " + orderOfHouses.peek().StringColor() + ", Location: (" + orderOfHouses.peek().X() + ", " + orderOfHouses.peek().Y() + "), and Owner: " + orderOfHouses.peek().name(), 0, 250);
        }
    }

    public void actionPerformed(ActionEvent event) {
        mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
        mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();

        for (int i = 0; i < notVisitedHouses.size(); i++) {
            if (checkIfstickManOnEgg(notVisitedHouses.get(i))) {
                visitedHouses.add(notVisitedHouses.get(i));

                distanceTraveled += (int) Math.sqrt((mouseX - previousX) * (mouseX - previousX) + (mouseY - previousY) * (mouseY - previousY));

                previousX = mouseX;
                previousY = mouseY;
            }
        }

        notVisitedHouses.removeAll(visitedHouses);

        House closestHouse = closestHouse();

        if (notVisitedHouses.size() > 0) {
            stickMan.setXSpeed(Buttons.mode * (int) (closestHouse.X() - stickMan.X()) / 20);
            stickMan.setYSpeed(Buttons.mode * (int) (closestHouse.Y() - stickMan.Y()) / 20);

            stickMan.setXCenter(stickMan.X() + stickMan.xSpeed());
            stickMan.setYCenter(stickMan.Y() + stickMan.ySpeed());
        }

        repaint();
    }

    public House closestHouse() {
        int distance = 1050;
        House closestHouse = new House();

        for (House house : notVisitedHouses) {
            int dx = stickMan.X() - house.X();
            int dy = stickMan.Y() - house.Y();

            if ((int) Math.sqrt((dx) * (dx) + (dy) * (dy)) < distance) {
                distance = (int) Math.sqrt((dx) * (dx) + (dy) * (dy));
                closestHouse = house;
            }
        }

        return closestHouse;
    }

    public boolean checkIfstickManOnEgg(House house) {
        if (((stickMan.X() < house.X() + 20) && (stickMan.X() > house.X() - 20)) && ((stickMan.Y() < house.Y() + 20) && (stickMan.Y() > house.Y() - 20))) {
            orderOfHouses.add(house);
            return true;
        }

        return false;
    }
}