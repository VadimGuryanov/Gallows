package ru.kpfu.itis.gallows.ui.paint_component;

import java.awt.geom.Point2D;
import java.util.Objects;

public class Point extends Point2D {

    private double x;
    private double y;
    private double x0;
    private double y0;


    public Point() {}

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.x0 = x;
        this.y0 = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void movie(double b, double c) {

    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Point point = (Point) o;
        return java.lang.Double.compare(point.x, x) == 0 &&
                java.lang.Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), x, y);
    }
}
