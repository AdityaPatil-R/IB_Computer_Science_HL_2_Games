import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class MacrosoftPAINT extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
    private static Color drawingColor = Color.BLACK;

    private static JPanel buttonPanel;
    private static JButton color, pencil, line, rectangle, ellipse, eraser;

    private static int numCurrentButton;

    private static ArrayList<Drawing> drawingsList = new ArrayList<Drawing>();
    private static Drawing currentDrawing;

    private static int xPosition, yPosition;
    private static int xOffset = 105, yOffset = 30;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Macrosoft.PAINT");
        frame.setLayout(new BorderLayout());

        buttonPanel = new JPanel(new GridLayout(6, 1));

        color = new JButton("Color");
        pencil = new JButton("Pencil");
        line = new JButton("Line");
        rectangle = new JButton("Rectangle");
        ellipse = new JButton("Ellipse");
        eraser = new JButton("Eraser");

        buttonPanel.add(color);
        buttonPanel.add(pencil);
        buttonPanel.add(line);
        buttonPanel.add(rectangle);
        buttonPanel.add(ellipse);
        buttonPanel.add(eraser);

        frame.add(buttonPanel, BorderLayout.WEST);
        frame.setSize(900, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MacrosoftPAINT MacrosoftPAINT = new MacrosoftPAINT();
        frame.addMouseListener(MacrosoftPAINT);
        frame.addMouseMotionListener(MacrosoftPAINT);

        Container container = frame.getContentPane();
        container.add(MacrosoftPAINT);

        frame.setVisible(true);
    }

    public MacrosoftPAINT() {
        drawingsList = new ArrayList<Drawing>();

        color.addActionListener(this);
        pencil.addActionListener(this);
        line.addActionListener(this);
        rectangle.addActionListener(this);
        ellipse.addActionListener(this);
        eraser.addActionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        if (currentDrawing != null) {
            currentDrawing.draw(g);
        }

        for (int i = 0; i < drawingsList.size(); i++) {
            if (drawingsList.get(i) != null) {
                drawingsList.get(i).draw(g);
            }
        }
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == color) {
            drawingColor = JColorChooser.showDialog(null, "Which color do you want to draw with?", Color.RED);
        }

        if (event.getSource() == pencil) {
            numCurrentButton = 0;
        }

        if (event.getSource() == line) {
            numCurrentButton = 1;
        }

        if (event.getSource() == rectangle) {
            numCurrentButton = 2;
        }

        if (event.getSource() == ellipse) {
            numCurrentButton = 3;
        }

        if (event.getSource() == eraser) {
            numCurrentButton = 4;
        }
    }

    public void mouseMoved(MouseEvent event) {
        repaint();

        xPosition = event.getX() - xOffset;
        yPosition = event.getY() - yOffset;
    }

    public void mouseDragged(MouseEvent event) {
        if (numCurrentButton == 0) {
            Drawing newPainting = new Drawing(0, new Rectangle(xPosition, yPosition, event.getX() - xOffset, event.getY() - yOffset), drawingColor);
            drawingsList.add(newPainting);
        }

        if (numCurrentButton == 1) {
            currentDrawing.drawingArea.width = event.getX() - xOffset;
            currentDrawing.drawingArea.height = event.getY() - yOffset;
        }

        if (numCurrentButton == 2 || numCurrentButton == 3) {
            currentDrawing.drawingArea.width = event.getX() - xOffset - currentDrawing.drawingArea.x;
            currentDrawing.drawingArea.height = event.getY() - yOffset - currentDrawing.drawingArea.y;
        }

        if (numCurrentButton == 4) {
            Drawing newPainting = new Drawing(4, new Rectangle(event.getX() - xOffset, event.getY() - yOffset, 50, 50), Color.WHITE);
            drawingsList.add(newPainting);
        }

        xPosition = event.getX() - xOffset;
        yPosition = event.getY() - yOffset;

        repaint();
    }

    public void mousePressed(MouseEvent event) {
        int numButtonChosen = -1;

        if (numCurrentButton == 1) {
            numButtonChosen = 1;
        }

        if (numCurrentButton == 2) {
            numButtonChosen = 2;
        }

        if (numCurrentButton == 3) {
            numButtonChosen = 3;
        }

        if (numButtonChosen != -1) {
            currentDrawing = new Drawing(numButtonChosen, new Rectangle(event.getX() - xOffset, event.getY() - yOffset, 0, 0), drawingColor);

            if (numButtonChosen == 1) {
                currentDrawing.drawingArea.width = currentDrawing.drawingArea.x;
                currentDrawing.drawingArea.height = currentDrawing.drawingArea.y;
            }
        }

        repaint();
    }

    public void mouseReleased(MouseEvent event) {
        drawingsList.add(currentDrawing);
    }

    public void mouseClicked(MouseEvent event) {

    }

    public void mouseEntered(MouseEvent event) {

    }

    public void mouseExited(MouseEvent event) {

    }
}