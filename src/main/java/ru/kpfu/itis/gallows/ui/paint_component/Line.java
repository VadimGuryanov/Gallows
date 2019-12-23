package ru.kpfu.itis.gallows.ui.paint_component;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Line extends Line2D {

    private Point p1;
    private Point p2;
    private double x0;
    private double y0;
    private int g;

    public Line(){}

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.x0 = p1.getX();
        this.y0 = p1.getY();
        g = 25;
    }

    public Line(double x1, double y1, double x2, double y2) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
        this.p1.setX(x1);
        this.p1.setY(y1);
        this.p2.setX(x2);
        this.p2.setY(y2);
        this.x0 = x2;
        this.y0 = y2;
        g = 25;
    }

    @Override
    public double getX1() {
        return p1.getX();
    }

    @Override
    public double getY1() {
        return p1.getY();
    }

    @Override
    public Point2D getP1() {
        return p1;
    }

    @Override
    public double getX2() {
        return p2.getX();
    }

    @Override
    public double getY2() {
        return p2.getY();
    }

    @Override
    public Point2D getP2() {
        return p2;
    }

    @Override
    public void setLine(double x1, double y1, double x2, double y2) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
        this.p1.setX(x1);
        this.p1.setY(y1);
        this.p2.setX(x2);
        this.p2.setY(y2);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    public void movieForearm(Point2D p1, Point2D p2) {
        if (p2.getX() < g)  {
            this.setLine(p1.getX(), p1.getY(), p2.getX() + 1.5, p2.getY() - 1.5);
            g = 67;
        } else {
            this.setLine(p1.getX(), p1.getY(), p2.getX() - 1.5, p2.getY() + 1.5);
            g = 52;
        }
    }
}

