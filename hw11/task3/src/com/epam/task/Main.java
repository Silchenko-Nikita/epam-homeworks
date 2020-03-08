package com.epam.task;

public class Main {

    public static void main(String[] args) {
	    TrianglesHolder trianglesHolder = new TrianglesHolder();

	    trianglesHolder.addTriangle(new Triangle(new Point[] {
	            new Point(0, 0), new Point(10, 5), new Point(-10, 0)}));
        trianglesHolder.addTriangle(new Triangle(new Point[] {
                new Point(-5, 3), new Point(10, 5), new Point(-10, -6)}));
        trianglesHolder.addTriangle(new Triangle(new Point[] {
                new Point(3, 0), new Point(5, 7), new Point(-3, 2)}));

        trianglesHolder.displayTriangles();
    }
}
