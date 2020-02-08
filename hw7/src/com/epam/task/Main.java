package com.epam.task;

import com.epam.task.shapes.*;

public class Main {

    static void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape.toString() + ", area: " + shape.calcArea());
        }
    }

    static double calcAreaSum(Shape[] shapes) {
        double area = 0.0;
        for (Shape shape : shapes) {
            area += shape.calcArea();
        }
        return area;
    }

    static double calcAreaSum(Shape[] shapes, Class klass) {
        double area = 0.0;
        for (Shape shape : shapes) {
            if (shape.getClass().equals(klass)) {
                area += shape.calcArea();
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle("black", 5, 4),
                new Rectangle("brown", 10, 6),
                new Rectangle("red", 3.5, 2.0),
                new Rectangle("green", 4.6, 3.0),
                new Circle("yellow", 1.0),
                new Circle("orange", 4.5),
                new Circle("gray", 9.0),
                new Triangle("blue", 1.0, 1.0, 1.0),
                new Triangle("red", 4.0, 2.5, 5.0),
        };

        System.out.println("Shapes array:");
        printShapes(shapes);
        System.out.println();

        System.out.print("Total shapes area: ");
        System.out.println(calcAreaSum(shapes));

        System.out.print("Total rectangles area: ");
        System.out.println(calcAreaSum(shapes, Rectangle.class));

        System.out.print("Total circles area: ");
        System.out.println(calcAreaSum(shapes, Circle.class));

        System.out.print("Total triangles area: ");
        System.out.println(calcAreaSum(shapes, Triangle.class));
    }
}
