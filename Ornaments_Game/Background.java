import java.awt.*;
import javax.swing.Timer;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.LinkedList;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;

public class Background extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    public static int time = 0;

    private int mouseX;
    private int mouseY;

    public static int offsetX = 275;
    public static int offsetY = 30;

    public static JPanel snowfallPanel;

    public static LinkedList<Snowflake> snowflakes = new LinkedList<Snowflake>();
    public static LinkedList<Ornament> ornaments = new LinkedList<Ornament>();
    public static LinkedList<Ornament> clickedOrnaments = new LinkedList<Ornament>();

    public static int totalOrnaments = 25;

    public Background() {
        Timer clock = new Timer(10, this);
        clock.start();

        Main.winterGameFrame.addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);

        g.fillRect(0, 0, 1000, 750);

        for (Snowflake snowflake : snowflakes) {
            snowflake.drawSnowflake(g);
        }

        g.setColor(new Color(78, 105, 26));

        g.fillPolygon(new int[] { 350, 290, 410 }, new int[] { 260, 345, 345 }, 3);
        g.fillPolygon(new int[] { 350, 250, 450 }, new int[] { 305, 425, 425 }, 3);
        g.fillPolygon(new int[] { 350, 210, 490 }, new int[] { 365, 505, 505 }, 3);

        g.setColor(new Color(90, 39, 41));

        g.fillRect(325, 505, 50, 125);

        for (Ornament ornament : ornaments) {
            ornament.drawOrnament(g);
        }

        for (Ornament ornament : clickedOrnaments) {
            ornament.drawOrnament(g);
        }

        g.setColor(Color.WHITE);

        g.fillRect(0, 625, 1000, 120);

        g.setColor(Color.BLACK);

        g.drawString(WinterGameButtons.evaluationComment, 10, 25);
        g.drawString(WinterGameButtons.additionalComment, 10, 50);

        g.drawString("Click the ornaments when they're on the tree to make them stay there!", 10, 650);
        g.drawString("When you feel the tree is sufficiently decorated, click the button to evaluate it!", 10, 675);
        g.drawString("I hope you enjoy this game!", 10, 700);
    }

    public void actionPerformed(ActionEvent event) {
        time++;

        if (time % 5 == 0) {
            mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX() - 275;
            mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY() - 45;
        }

        if (!WinterGameButtons.endGame) {
            if (time % 25 == 0) {
                if (snowflakes.size() < 75) {
                    snowflakes.add(new Snowflake());
                }
            }

            if (time % 50 == 0) {
                if (ornaments.size() < totalOrnaments) {
                    ornaments.add(new Ornament());
                }
            }
        }

        if (!WinterGameButtons.endGame) {
            for (Snowflake snowflake : snowflakes) {
                snowflake.updateSnowflakeFall();
            }

            for (Ornament ornament : ornaments) {
                ornament.updateOrnamentFall();
            }
        }

        if (time % 25 == 0) {
            for (Ornament ornament : ornaments) {
                ornament.setOrnamentSpeed(WinterGameButtons.whichMode * (int) (ornament.getOrnamentRadius() / 3));
            }
        }

        repaint();
    }

    public boolean checkIfOrnamentOnTree(Ornament ornament) {
        if (ornament.getOrnamentYPosition() <= 505) {
            if (ornament.getOrnamentYPosition() >= 1.75 * (201 - ornament.getOrnamentXPosition()) + 505) {
                if (ornament.getOrnamentYPosition() >= 1.75 * (ornament.getOrnamentXPosition() - 350) + 260) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkIfMouseOnTree() {
        if (mouseY <= 505) {
            if (mouseY >= 1.75 * (201 - mouseX) + 505) {
                if (mouseY >= 1.75 * (mouseX - 350) + 260) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkIfMouseOnOrnament() {
        for (Ornament ornament : ornaments) {
            if ((mouseX < ornament.getOrnamentXPosition() + 3 * ornament.getOrnamentRadius()) && (mouseX > ornament.getOrnamentXPosition() - 3 * ornament.getOrnamentRadius())) {
                if ((mouseY < ornament.getOrnamentYPosition() + 3 * ornament.getOrnamentRadius()) && (mouseY > ornament.getOrnamentYPosition() - 3 * ornament.getOrnamentRadius())) {
                    return true;
                }
            }
        }

        return false;
    }

    public void mouseMoved(MouseEvent event) {
        mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
        mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
    }

    public void mousePressed(MouseEvent event) {
        for (Ornament ornament : ornaments) {
            if ((checkIfMouseOnTree()) && (checkIfMouseOnOrnament()) && (checkIfOrnamentOnTree(ornament))) {
                ornament.setOrnamentSpeed(0);
                clickedOrnaments.add(ornament);
                ornaments.remove(ornament);
                totalOrnaments--;
            }
        }
    }

    public void mouseDragged(MouseEvent event) {
        
    }

    public void mouseClicked(MouseEvent event) {
        
    }

    public void mouseEntered(MouseEvent event) {
        
    }

    public void mouseReleased(MouseEvent event) {
        
    }

    public void mouseExited(MouseEvent event) {
        
    }
}