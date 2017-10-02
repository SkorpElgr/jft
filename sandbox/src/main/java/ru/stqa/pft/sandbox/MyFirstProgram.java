package ru.stqa.pft.sandbox;

/**
 * Created by Admin on 01.10.2017.
 */
public class MyFirstProgram {
    public static void main(String[] args) {
        Point pointA = new Point(1, 1);
        Point pointB = new Point(2, 2);
        print("Distance between pointA and pointB is: " + String.format("%.3f", distance(pointA, pointB)));
        print("Distance between x1, y1 and x2, y2 is: " + distanceBetweenPoints(1, 3, 1.5, 1.4624));
        print("Distance to specified point is: " + String.format("%.3f", pointA.distanceFromCurrentPoint(pointB)));
        print("Distance to specified point with coordinates X,Y: " + String.format("%.3f", pointA.distanceToCoordinates(3.3, 4)));
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static double area(double a) {
        return (a * a);
    }

    public static double area(double a, double b) {
        return (a * b);
    }

    public static double distance(Point pointA, Point pointB) {
        return Math.sqrt(Math.pow((pointB.x - pointA.x), 2) + (Math.pow((pointB.y - pointA.y), 2)));
    }

    public static double distanceBetweenPoints(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + (Math.pow((y1 - y2), 2)));
    }
}
