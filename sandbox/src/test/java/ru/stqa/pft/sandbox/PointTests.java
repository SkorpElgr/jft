package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

import static ru.stqa.pft.sandbox.MyFirstProgram.distance;
import static ru.stqa.pft.sandbox.MyFirstProgram.distanceBetweenPoints;

/**
 * Created by Admin on 02.10.2017.
 */
public class PointTests {
    @Test
    public void pointTestOne() {
        Point pointA = new Point(1, 1);
        Point pointB = new Point(2, 1);
        assert distance(pointA, pointB) == 1;
    }

    @Test
    public void pointTestTwo() {
        Point pointA = new Point(1, 1);
        Point pointB = new Point(2, 2);
        assert pointA.distanceFromCurrentPoint(pointB) == Math.sqrt(2);
    }

    @Test
    public void pointTestThree() {
        assert distanceBetweenPoints(1, 3, 1.5, 1.4624) == 1.6168530421779217;
//        =sqrt((x2-x1)^2+(y2-y1)^2)
//        =sqrt((1.5-1)^2+(1.4624-3)^2)
//        =sqrt(0.25+2.36421376)
//        =sqrt(2.61421376)
//        =1.6168530421779217
//        =1.6169
    }
}
