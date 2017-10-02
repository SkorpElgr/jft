package ru.stqa.pft.sandbox;

/**
 * Created by Admin on 02.10.2017.
 */
public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double squareRoot(Double a) {
        return Math.sqrt(a);
    }

    public double pow2(Double value) {
        return (Math.pow(value, 2));
    }

    public double distanceFromCurrentPoint(Point point) {
        return squareRoot(pow2((point.x - this.x)) + (pow2(point.y - this.y)));
    }
    public double distanceToCoordinates(double x, double y) {
        return squareRoot(pow2((x - this.x)) + (pow2(y - this.y)));
    }
}
