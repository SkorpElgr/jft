package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

/**
 * Created by Admin on 01.10.2017.
 */
public class SquareTests {

    @Test
    public void positiveArea(){
        Square s = new Square(5);
        assert s.area() == 25;
    }

    @Test
    public void negativeArea(){
        Square s = new Square(5);
        assert !(s.area() == 26);
    }
}
