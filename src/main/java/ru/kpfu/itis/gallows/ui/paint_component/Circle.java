package ru.kpfu.itis.gallows.ui.paint_component;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circle extends Ellipse2D {

    private Point point;
    private double width;
    private double heght;

    public Circle() {
        point = new Point();
    }

    public Circle(double x, double y, double width, double heght) {
        this.point = new Point(x, y);
        this.width = width;
        this.heght = heght;
    }

    @Override
    public double getX() {
        return point.getX();
    }

    @Override
    public double getY() {
        return point.getY();
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return heght;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {
        point.setLocation(x, y);
        this.width = w;
        this.heght = h;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
}
