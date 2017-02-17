package ru.stqa.pft.homework;

/**
 * Created by Summoner on 11.02.2017.
 */
 public class Point {
    private double x;
    private double y;

    public Point()
    {
    }

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double distance(Point p1, Point p2)
    {
        if(p1.getX() == p2.getX()) {
            return Math.abs(p1.getY() - p2.getY());
        }
        else
        if (p1.getY() == p2.getY()){
            return Math.abs(p1.getX() - p2.getX());
        }
        else {
            return Math.sqrt(Math.abs(p1.getX() - p2.getX()) * Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY()) * Math.abs(p1.getY() - p2.getY()));
        }
    }

    public double distance(Point p)
    {
        if(this.x == p.getX()) {
            return Math.abs(this.y - p.getY());
        }
        else
        if (this.y == p.getY()){
            return Math.abs(this.x - p.getX());
        }
        else {
            return Math.sqrt(Math.abs(this.x - p.getX()) * Math.abs(this.x - p.getX()) + Math.abs(this.y - p.getY()) * Math.abs(this.y - p.getY()));
        }
    }

    public static double distance1(Point p1, Point p2)
    {
        if(p1.getX() == p2.getX()) {
            return Math.abs(p1.getY() - p2.getY());
        }
        else
        if (p1.getY() == p2.getY()){
            return  Math.abs(p1.getX() - p2.getX());
        }
        else {
            return Math.sqrt(Math.abs(p1.getX() - p2.getX()) * Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY()) * Math.abs(p1.getY() - p2.getY()));
        }
    }
}
