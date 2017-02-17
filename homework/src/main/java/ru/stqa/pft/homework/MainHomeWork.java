package ru.stqa.pft.homework;

/**
 * Created by Summoner on 11.02.2017.
 */
public class MainHomeWork {
    public static void main(String[] args) {
        double x1 = 1, y1 = 1, x2 = 5, y2 = 5;

        Point p1 = new Point(x1,y1);
        Point p2 = new Point(x2,y2);
        System.out.println("Расстояние между двумя точками равно: " + distance(p1, p2));

        Point p3 = new Point();
        System.out.println("Расстояние между двумя точками равно: " + p3.distance(p1, p2));

        System.out.println("Расстояние между двумя точками равно: " + Point.distance1(p1, p2));

        System.out.println("Расстояние между двумя точками равно: " + p1.distance(p2));
    }

    public static double distance(Point p1, Point p2)
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