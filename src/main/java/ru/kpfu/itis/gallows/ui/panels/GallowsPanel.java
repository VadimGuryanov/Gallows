package ru.kpfu.itis.gallows.ui.panels;

import ru.kpfu.itis.gallows.ui.paint_component.Circle;
import ru.kpfu.itis.gallows.ui.paint_component.Line;

import javax.swing.*;
import java.awt.*;

public class GallowsPanel extends JPanel {

    private Line baseLeft;
    private Line baseRight;
    private Line baseLeftV;
    private Line baseRightV;
    private Line pillar;
    private Line canopy;
    private Line mount;
    private Line loop;
    private Line leftHand;
    private Line rightHand;
    private Line leftLeg;
    private Line rightLeg;
    private Line body;
    private Line knot;
    private Line leftEye1;
    private Line rigthEye1;
    private Line leftEye2;
    private Line rigthEye2;
    private Circle head;
    private Circle loopCircle;
    private Line loopLine;


    public GallowsPanel() {
        baseLeft = new Line(-10,-10,-10,-10);
        baseRight = new Line(-10,-10,-10,-10);
        pillar = new Line(-10,-10,-10,-10);
        canopy = new Line(-10,-10,-10,-10);
        mount = new Line(-10,-10,-10,-10);
        loop = new Line(-10,-10,-10,-10);
        leftHand = new Line(-10,-10,-10,-10);
        rightHand = new Line(-10,-10,-10,-10);
        leftLeg = new Line(-10,-10,-10,-10);
        rightLeg = new Line(-10,-10,-10,-10);
        body = new Line(-10,-10,-10,-10);
        head = new Circle(-10,-10,-10,-10);
        baseLeftV = new Line(-10,-10,-10,-10);
        baseRightV = new Line(-10,-10,-10,-10);
        knot = new Line(-10,-10,-10,-10);
        leftEye1 = new Line(-10,-10,-10,-10);
        rigthEye1 = new Line(-10,-10,-10,-10);
        leftEye2 = new Line(-10,-10,-10,-10);
        rigthEye2 = new Line(-10,-10,-10,-10);
        loopCircle = new Circle(-10,-10,-10,-10);
        loopLine = new Line(-10,-10,-10,-10);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(8.0f));
        g2.setColor(new Color(153, 77, 0));
        g2.draw(baseLeft);
        g2.draw(baseRight);
        g2.draw(baseRightV);
        g2.draw(baseLeftV);
        g2.draw(pillar);
        g2.setStroke(new BasicStroke(6.0f));
        g2.draw(mount);
        g2.setStroke(new BasicStroke(4.0f));
        g2.draw(canopy);
        g2.setColor(new Color(179, 92, 0));
        g2.setStroke(new BasicStroke(10.0f));
        g2.draw(knot);
        g2.setStroke(new BasicStroke(4.0f));
        g2.draw(loopCircle);
        g2.setStroke(new BasicStroke(3.5f));
        g2.draw(loopLine);
        g2.setStroke(new BasicStroke(2.0f));
        g2.draw(loop);
        g2.setColor(Color.black);
        g2.draw(leftHand);
        g2.draw(rightHand);
        g2.draw(leftLeg);
        g2.draw(rightLeg);
        g2.draw(body);
        g2.draw(head);
        g2.draw(leftEye1);
        g2.draw(leftEye2);
        g2.draw(rigthEye1);
        g2.draw(rigthEye2);
    }

    public void repaintView(int mistake) {
        switch (mistake) {
            case 1: {
                baseLeft = new Line(50,300,100,300);
                break;
            }
            case 2: {
                baseLeft = new Line(50,300,100,300);
                baseRight = new Line(150,300,100,300);
                break;
            }
            case 3: {
                baseLeft = new Line(50,300,100,300);
                baseRight = new Line(150,300,100,300);
                baseLeftV = new Line(75,298,100,275);
                baseRightV = new Line(125,298,100,275);
                pillar = new Line(100,300,100,30);
                break;
            }
            case 4: {
                baseLeft = new Line(50,300,100,300);
                baseRight = new Line(150,300,100,300);
                baseLeftV = new Line(75,298,100,275);
                baseRightV = new Line(125,298,100,275);
                pillar = new Line(100,300,100,30);
                canopy = new Line(100,30,250,30);
                break;
            }
            case 5: {
                baseLeft = new Line(50,300,100,300);
                baseRight = new Line(150,300,100,300);
                baseLeftV = new Line(75,298,100,275);
                baseRightV = new Line(125,298,100,275);
                pillar = new Line(100,300,100,30);
                canopy = new Line(100,30,250,30);
                mount = new Line(101,65,135,32);
                break;
            }
            case 6: {
                baseLeft = new Line(50,300,100,300);
                baseRight = new Line(150,300,100,300);
                baseLeftV = new Line(75,298,100,275);
                baseRightV = new Line(125,298,100,275);
                pillar = new Line(100,300,100,30);
                canopy = new Line(100,30,250,30);
                mount = new Line(101,65,135,32);
                loop = new Line(225,27,225,60);
                knot = new Line(215,30,235,30);
                loopLine = new Line(225, 60, 225, 70);
                loopCircle = new Circle(215, 75, 20, 40);
                break;
            }
            case 7: {
                baseLeft = new Line(50,300,100,300);
                baseRight = new Line(150,300,100,300);
                baseLeftV = new Line(75,298,100,275);
                baseRightV = new Line(125,298,100,275);
                pillar = new Line(100,300,100,30);
                canopy = new Line(100,30,250,30);
                mount = new Line(101,65,135,32);
                loop = new Line(225,27,225,60);
                head = new Circle(205,60,40,40);
                knot = new Line(215,30,235,30);
                leftEye1 = new Line(215,80,220,90);
                rigthEye1 = new Line(240,80,235,90);
                leftEye2 = new Line(215,90,220,80);
                rigthEye2 = new Line(240,90,235,80);
                break;
            }
            case 8: {
                baseLeft = new Line(50,300,100,300);
                baseRight = new Line(150,300,100,300);
                baseLeftV = new Line(75,298,100,275);
                baseRightV = new Line(125,298,100,275);
                pillar = new Line(100,300,100,30);
                canopy = new Line(100,30,250,30);
                mount = new Line(101,65,135,32);
                loop = new Line(225,27,225,60);
                head = new Circle(205,60,40,40);
                knot = new Line(215,30,235,30);
                body = new Line(225,100,225,180);
                leftEye1 = new Line(215,80,220,90);
                rigthEye1 = new Line(240,80,235,90);
                leftEye2 = new Line(215,90,220,80);
                rigthEye2 = new Line(240,90,235,80);
                break;
            }
            case 9: {
                baseLeft = new Line(50,300,100,300);
                baseRight = new Line(150,300,100,300);
                baseLeftV = new Line(75,298,100,275);
                baseRightV = new Line(125,298,100,275);
                pillar = new Line(100,300,100,30);
                canopy = new Line(100,30,250,30);
                mount = new Line(101,65,135,32);
                loop = new Line(225,27,225,60);
                leftLeg = new Line(225,180,210,230);
                body = new Line(225,100,225,180);
                head = new Circle(205,60,40,40);
                knot = new Line(215,30,235,30);
                leftEye1 = new Line(215,80,220,90);
                rigthEye1 = new Line(240,80,235,90);
                leftEye2 = new Line(215,90,220,80);
                rigthEye2 = new Line(240,90,235,80);
                break;
            }
            case 10: {
                baseLeft = new Line(50,300,100,300);
                baseRight = new Line(150,300,100,300);
                baseLeftV = new Line(75,298,100,275);
                baseRightV = new Line(125,298,100,275);
                pillar = new Line(100,300,100,30);
                canopy = new Line(100,30,250,30);
                mount = new Line(101,65,135,32);
                loop = new Line(225,27,225,60);
                leftLeg = new Line(225,180,210,230);
                rightLeg = new Line(225,180,240,230);
                body = new Line(225,100,225,180);
                head = new Circle(205,60,40,40);
                knot = new Line(215,30,235,30);
                leftEye1 = new Line(215,80,220,90);
                rigthEye1 = new Line(240,80,235,90);
                leftEye2 = new Line(215,90,220,80);
                rigthEye2 = new Line(240,90,235,80);
                break;
            }
            case 11: {
                baseLeft = new Line(50,300,100,300);
                baseRight = new Line(150,300,100,300);
                baseLeftV = new Line(75,298,100,275);
                baseRightV = new Line(125,298,100,275);
                pillar = new Line(100,300,100,30);
                canopy = new Line(100,30,250,30);
                mount = new Line(101,65,135,32);
                loop = new Line(225,27,225,60);
                leftHand = new Line(225,115,212,175);
                leftLeg = new Line(225,180,210,230);
                rightLeg = new Line(225,180,240,230);
                body = new Line(225,100,225,180);
                head = new Circle(205,60,40,40);
                knot = new Line(215,30,235,30);
                leftEye1 = new Line(215,80,220,90);
                rigthEye1 = new Line(240,80,235,90);
                leftEye2 = new Line(215,90,220,80);
                rigthEye2 = new Line(240,90,235,80);
                break;
            }
            case 12: {
                baseLeft = new Line(50,300,100,300);
                baseRight = new Line(150,300,100,300);
                baseLeftV = new Line(75,298,100,275);
                baseRightV = new Line(125,298,100,275);
                pillar = new Line(100,300,100,30);
                canopy = new Line(100,30,250,30);
                mount = new Line(101,65,135,32);
                loop = new Line(225,27,225,60);
                leftHand = new Line(225,115,212,175);
                rightHand = new Line(225,115,238,175);
                leftLeg = new Line(225,180,210,230);
                rightLeg = new Line(225,180,240,230);
                body = new Line(225,100,225,180);
                head = new Circle(205,60,40,40);
                knot = new Line(215,30,235,30);
                leftEye1 = new Line(215,80,220,90);
                rigthEye1 = new Line(240,80,235,90);
                leftEye2 = new Line(215,90,220,80);
                rigthEye2 = new Line(240,90,235,80);
                break;
            }
        }
        this.repaint();
    }
}
