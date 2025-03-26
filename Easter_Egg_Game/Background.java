import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;
import java.awt.event.*;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Background extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    private int mouseX;
    private int mouseY;

    private Timer clock;

    private LinkedList<Egg> eggsOnScreen;
    public static LinkedList<Egg> clickedEggs;
    public static LinkedList<Egg> bunnyEggs;

    public static HashMap<Color, Integer> colorValues;

    public static PriorityQueue<Egg> orderOfEggs;

    public static int playerEval;
    public static int bunnyEval;

    private Bunny bunny;

    private boolean actionPerformedRunning = false;

    public Background() {
        clock = new Timer(10, this);

        eggsOnScreen = new LinkedList<Egg>();
        clickedEggs = new LinkedList<Egg>();
        bunnyEggs = new LinkedList<Egg>();

        bunny = new Bunny();

        mouseX = 0;
        mouseY = 0;

        colorValues = new HashMap<Color, Integer>();

        orderOfEggs = new PriorityQueue<Egg>();

        setPreferredSize(new Dimension(1000, 750));
        setBackground(new Color(144, 238, 144));

        addMouseListener(this);
        addMouseMotionListener(this);

        for (int i = 0; i < 25; i++) {
            eggsOnScreen.add(new Egg());
        }

        for (int i = 0; i < Egg.colors.length; i++) {
            colorValues.put(Egg.colors[i], (int) (Math.random() * (Egg.colors.length + 3)));
        }

        clock.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Egg egg : eggsOnScreen) {
            egg.drawEgg(g);
        }

        bunny.drawBunny(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 625, 1000, 120);

        g.setColor(Color.BLACK);
        g.drawString(Buttons.evaulationComment, 10, 30);
        g.drawString(Buttons.orderComment, 100, 100);
        g.drawString("Try to click the easter egg before the bunny can get to it", 10, 650);
        g.drawString("When you want to end the game, click the \"End Game\" button to see how well you did againt the bunny", 10, 675);
        g.drawString("I hope you enjoy this game!", 10, 700);

        g.drawString("Your current coordinates are (" + mouseX + ", " + mouseY + ")", 650, 700);
    }

    public void actionPerformed(ActionEvent event) {
        if (actionPerformedRunning) {
            return;
        }

        mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
        mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();

        for (int i = 0; i < eggsOnScreen.size(); i++) {
            if (checkIfBunnyOnEgg(eggsOnScreen.get(i))) {
                bunnyEggs.add(eggsOnScreen.get(i));
            }
        }

        eggsOnScreen.removeAll(bunnyEggs);
        eggsOnScreen.removeAll(clickedEggs);

        Egg closestEgg = closestEgg();

        if (eggsOnScreen.size() > 0) {
            bunny.setXSpeed(Buttons.mode * (int) (closestEgg.X() - bunny.X()) / 20);
            bunny.setYSpeed(Buttons.mode * (int) (closestEgg.Y() - bunny.Y()) / 20);

            bunny.setXCenter(bunny.X() + bunny.xSpeed());
            bunny.setYCenter(bunny.Y() + bunny.ySpeed());
        }

        repaint();
    }

    public Egg closestEgg() {
        int distance = 1050;
        Egg closestEgg = new Egg();

        for (Egg egg : eggsOnScreen) {
            int dx = bunny.X() - egg.X();
            int dy = bunny.Y() - egg.Y();

            if ((int) Math.sqrt((dx) * (dx) + (dy) * (dy)) < distance) {
                distance = (int) Math.sqrt((dx) * (dx) + (dy) * (dy));
                closestEgg = egg;
            }
        }

        return closestEgg;
    }

    public boolean checkIfBunnyOnEgg(Egg egg) {
        if (((bunny.X() < egg.X() + 20) && (bunny.X() > egg.X() - 20)) && ((bunny.Y() < egg.Y() + 20) && (bunny.Y() > egg.Y() - 20))) {
            bunnyEval += colorValues.get(egg.Color());
            return true;
        }

        return false;
    }

    public void mouseMoved(MouseEvent event) {
        mouseX = (int) event.getX();
        mouseY = (int) event.getY();
    }

    public void mouseClicked(MouseEvent event) {
        for (int i = 0; i < eggsOnScreen.size(); i++) {
            Egg egg = eggsOnScreen.get(i);

            if (((mouseX < egg.X() + 120 + 10) && (mouseX > egg.X() + 120 - 10)) && ((mouseY < egg.Y() + 30 + 10) && (mouseY > egg.Y() + 30 - 10))) {
                playerEval += colorValues.get(egg.Color());
                clickedEggs.add(egg);
            }
        }
    }

    public void mouseDragged(MouseEvent event) {
        for (int i = 0; i < eggsOnScreen.size(); i++) {
            Egg egg = eggsOnScreen.get(i);

            if (((mouseX < egg.X() + 120 + 10) && (mouseX > egg.X() + 120 - 10)) && ((mouseY < egg.Y() + 30 + 10) && (mouseY > egg.Y() + 30 - 10))) {
                playerEval += colorValues.get(egg.Color());
                clickedEggs.add(egg);
            }
        }
    }

    public void mousePressed(MouseEvent event) {

    }

    public void mouseEntered(MouseEvent event) {

    }

    public void mouseReleased(MouseEvent event) {

    }

    public void mouseExited(MouseEvent event) {

    }
}