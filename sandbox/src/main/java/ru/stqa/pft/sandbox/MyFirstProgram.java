package ru.stqa.pft.sandbox;

/**
 * Created by Admin on 01.10.2017.
 */
public class MyFirstProgram {
    public static void main(String[] args) {
        Point pointA = new Point(1, 1);
        Point pointB = new Point(2, 2);
        print("Distance between pointA and pointB is: " + String.format("%.3f", distance(pointA, pointB)));
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
}
