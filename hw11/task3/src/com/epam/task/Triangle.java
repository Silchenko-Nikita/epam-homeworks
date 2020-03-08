package com.epam.task;

import java.util.Arrays;

public class Triangle {
    private Point[] points;

    public Triangle(Point[] points) {
        this.points = Arrays.copyOf(points,3);
    }

    public TriangleType getTriangleType() {
        double a = Math.sqrt(Math.pow(points[0].getX() - points[1].getX(), 2) +
                Math.pow(points[0].getY() - points[1].getY(), 2));
        double b = Math.sqrt(Math.pow(points[0].getX() - points[2].getX(), 2) +
                Math.pow(points[0].getY() - points[2].getY(), 2));
        double c = Math.sqrt(Math.pow(points[2].getX() - points[1].getX(), 2) +
                Math.pow(points[2].getY() - points[1].getY(), 2));

        if (a == b && b == c) {
            return TriangleType.EQUILATERAL;
        }

        if (a == b || b == c || a == c) {
            return TriangleType.ISOSCELES;
        }

        if ((Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)) ||
                (Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2)) ||
                (Math.pow(c, 2) == Math.pow(b, 2) + Math.pow(a, 2))) {
            return TriangleType.RIGHT;
        }

        return TriangleType.DIFFERENT;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + Arrays.toString(points) + ", " +
                "type=" + getTriangleType() +
                '}';
    }
}
