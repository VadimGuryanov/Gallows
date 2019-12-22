package ru.kpfu.itis.gallows.ui.panels;

import ru.kpfu.itis.gallows.ui.paint_component.Circle;
import ru.kpfu.itis.gallows.ui.paint_component.Line;
import ru.kpfu.itis.gallows.ui.paint_component.Point;

import javax.swing.*;
import java.awt.*;

public class ManPanel extends JPanel implements Runnable {

    private Line leftHand;
    private Line leftForearm;
    private Line rightHand;
    private Line leftLeg;
    private Line rightLeg;
    private Line body;
    private Circle head;
    private Circle leftEye;
    private Circle rightEye;
    private double[] yMouth;

    public ManPanel() {
        leftLeg = new Line(90, 180, 105, 120);
        rightLeg = new Line(120, 180, 105, 120);
        body = new Line(105, 120, 105, 60);
        head = new Circle(85, 20, 40, 40);
        leftEye = new Circle(90, 28, 13, 13);
        rightEye = new Circle(107, 28, 13, 13);
        rightHand = new Line(105, 75, 115, 115);
        leftHand = new Line(105, 75, 80, 65);
        leftForearm = new Line(80, 65, 75, 30);
        yMouth = getMouth();
        new Thread(this).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2.0f));
        g2.draw(leftEye);
        g2.draw(rightEye);
        for (int x = 10; x < 40; x++) {
            g2.draw(new Line(new Point(92+x*0.5, yMouth[x]), new Point(92+x*0.5, yMouth[x])));
        }
        g2.setStroke(new BasicStroke(3.0f));
        g2.draw(new Line(96, 34, 96, 34));
        g2.draw(new Line(114, 34, 114, 34));
        g2.draw(head);
        g2.draw(leftHand);
        g2.draw(rightHand);
        g2.draw(leftLeg);
        g2.draw(rightLeg);
        g2.draw(body);
        g2.draw(leftForearm);

    }

    @Override
    public void run() {
        try {
            while(true) {
                leftForearm.movieForearm(leftForearm.getP1(), leftForearm.getP2());
                super.repaint();
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double[] getMouth() {
        double[] y = new double[50];
        for (int x = 0; x < 50; x++) {
            y[x] = -0.03*(x-25)*(x-25) + 52;
            System.out.println(y[x]);
        }
        return y;
    }
}
