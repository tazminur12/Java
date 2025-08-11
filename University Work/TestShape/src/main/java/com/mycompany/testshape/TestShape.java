

package com.mycompany.testshape;

import java.util.ArrayList;

public class TestShape {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle("Red", 5));
        shapes.add(new Rectangle("Blue", 4, 6));

        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.println("-------------------");
        }
    }
}
