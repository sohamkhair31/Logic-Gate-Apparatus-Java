import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GatePanel extends JPanel {

    private boolean power = false;
    private boolean inputA = false;
    private boolean inputB = false;
    private int selectedGate = -1;

    public GatePanel() {
        setLayout(null);
        setBackground(new Color(190, 255, 255));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                selectedGate = -1;

                if (x >= 90 && x <= 180 && y >= 90 && y <= 170) selectedGate = 0;
                else if (x >= 90 && x <= 180 && y >= 210 && y <= 290) selectedGate = 1;
                else if (x >= 90 && x <= 180 && y >= 330 && y <= 410) selectedGate = 2;
                else if (x >= 290 && x <= 370 && y >= 90 && y <= 170) selectedGate = 3;
                else if (x >= 290 && x <= 380 && y >= 210 && y <= 290) selectedGate = 4;
                else if (x >= 290 && x <= 380 && y >= 330 && y <= 410) selectedGate = 5;
                else if (x >= 490 && x <= 560 && y >= 210 && y <= 250) selectedGate = 6;

                repaint();
            }
        });
    }

    public void setPower(boolean power) {
        this.power = power;
        repaint();
    }

    public void setInputA(boolean inputA) {
        this.inputA = inputA;
        repaint();
    }

    public void setInputB(boolean inputB) {
        this.inputB = inputB;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        Color offColor = Color.RED;
        Color onColor = Color.GREEN;

        boolean andOut = power && (inputA && inputB);
        boolean nandOut = power && !(inputA && inputB);
        boolean orOut = power && (inputA || inputB);
        boolean norOut = power && !(inputA || inputB);
        boolean xorOut = power && (inputA ^ inputB);
        boolean xnorOut = power && !(inputA ^ inputB);
        boolean notOut = power && !inputA;

        drawAndGate(g2, andOut);
        drawNandGate(g2, nandOut);
        drawOrGate(g2, orOut);
        drawNorGate(g2, norOut);
        drawXorGate(g2, xorOut);
        drawXnorGate(g2, xnorOut);
        drawNotGate(g2, notOut);
    }

    private void drawAndGate(Graphics2D g2, boolean output) {
        g2.setColor(selectedGate == 0 ? Color.BLACK : Color.GRAY);
        g2.drawArc(90, 90, 60, 80, -90, 180);
        g2.drawLine(120, 90, 120, 170);
        g2.drawLine(120, 110, 70, 110);
        g2.drawLine(120, 150, 70, 150);
        g2.drawLine(150, 130, 180, 130);
        g2.drawString("AND", 100, 85);
        g2.setColor(selectedGate == 0 ? (output ? Color.GREEN : Color.RED) : Color.RED);
        g2.fillOval(185, 120, 20, 20);
    }

    private void drawNandGate(Graphics2D g2, boolean output) {
        g2.setColor(selectedGate == 1 ? Color.BLACK : Color.GRAY);
        g2.drawArc(90, 210, 60, 80, -90, 180);
        g2.drawLine(120, 210, 120, 290);
        g2.drawLine(120, 230, 70, 230);
        g2.drawLine(120, 270, 70, 270);
        g2.drawLine(150, 250, 170, 250);
        g2.drawOval(170, 245, 10, 10);
        g2.drawString("NAND", 95, 205);
        g2.setColor(selectedGate == 1 ? (output ? Color.GREEN : Color.RED) : Color.RED);
        g2.fillOval(185, 240, 20, 20);
    }

    private void drawOrGate(Graphics2D g2, boolean output) {
        g2.setColor(selectedGate == 2 ? Color.BLACK : Color.GRAY);
        g2.drawArc(90, 330, 60, 80, -90, 180);
        g2.drawLine(120, 330, 120, 410);
        g2.drawLine(120, 350, 70, 350);
        g2.drawLine(120, 390, 70, 390);
        g2.drawLine(150, 370, 180, 370);
        g2.drawString("OR", 100, 325);
        g2.setColor(selectedGate == 2 ? (output ? Color.GREEN : Color.RED) : Color.RED);
        g2.fillOval(185, 360, 20, 20);
    }

    private void drawNorGate(Graphics2D g2, boolean output) {
        g2.setColor(selectedGate == 3 ? Color.BLACK : Color.GRAY);
        g2.drawArc(290, 90, 60, 80, -90, 180);
        g2.drawLine(320, 90, 320, 170);
        g2.drawLine(320, 110, 270, 110);
        g2.drawLine(320, 150, 270, 150);
        g2.drawLine(350, 130, 370, 130);
        g2.drawOval(370, 125, 10, 10);
        g2.drawString("NOR", 300, 85);
        g2.setColor(selectedGate == 3 ? (output ? Color.GREEN : Color.RED) : Color.RED);
        g2.fillOval(385, 120, 20, 20);
    }

    private void drawXorGate(Graphics2D g2, boolean output) {
        g2.setColor(selectedGate == 4 ? Color.BLACK : Color.GRAY);
        g2.drawArc(290, 210, 60, 80, -90, 180);
        g2.drawArc(280, 210, 60, 80, -90, 180);
        g2.drawLine(310, 210, 310, 290);
        g2.drawLine(310, 230, 270, 230);
        g2.drawLine(310, 270, 270, 270);
        g2.drawLine(350, 250, 380, 250);
        g2.drawString("XOR", 300, 205);
        g2.setColor(selectedGate == 4 ? (output ? Color.GREEN : Color.RED) : Color.RED);
        g2.fillOval(385, 240, 20, 20);
    }

    private void drawXnorGate(Graphics2D g2, boolean output) {
        g2.setColor(selectedGate == 5 ? Color.BLACK : Color.GRAY);
        g2.drawArc(290, 330, 60, 80, -90, 180);
        g2.drawArc(280, 330, 60, 80, -90, 180);
        g2.drawLine(310, 330, 310, 410);
        g2.drawLine(310, 350, 270, 350);
        g2.drawLine(310, 390, 270, 390);
        g2.drawLine(350, 370, 370, 370);
        g2.drawOval(370, 365, 10, 10);
        g2.drawString("XNOR", 300, 325);
        g2.setColor(selectedGate == 5 ? (output ? Color.GREEN : Color.RED) : Color.RED);
        g2.fillOval(385, 360, 20, 20);
    }

    private void drawNotGate(Graphics2D g2, boolean output) {
        g2.setColor(selectedGate == 6 ? Color.BLACK : Color.GRAY);
        int[] xPoints = {490, 490, 530};
        int[] yPoints = {210, 250, 230};
        g2.drawPolygon(xPoints, yPoints, 3);
        g2.drawLine(490, 230, 470, 230);
        g2.drawLine(530, 230, 560, 230);
        g2.drawOval(560, 225, 10, 10);
        g2.drawString("NOT (A)", 490, 200);
        g2.setColor(selectedGate == 6 ? (output ? Color.GREEN : Color.RED) : Color.RED);
        g2.fillOval(575, 220, 20, 20);
    }
}
