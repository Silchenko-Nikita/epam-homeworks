package com.epam.task;

import java.util.HashSet;

public class TrianglesHolder {
    HashSet<Triangle> triangles = new HashSet<>();

    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }

    public void displayTriangles() {
        for (Triangle triangle: triangles) {
            System.out.println(triangle);
        }
    }
}
