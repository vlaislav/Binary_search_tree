package org.example;

import java.util.ArrayList;

class Shape {
     private double volume;

    public Shape(double volume) {
        this.volume = volume;
    }

    public  double getVolume() {
        return volume;
    }
}

class SolifOfRevolution extends Shape{
     private double radius;

public SolifOfRevolution(double volume, double radius) {
     super(volume);
     this.radius = radius;
}

public double getRadius() {
     return radius;
}
}

class Ball extends SolifOfRevolution{
    public Ball(double radius) {
        super(Math.PI * Math.pow(radius, 3) * 4 / 3, radius);
    }
}

class Cylinder extends SolifOfRevolution {
    private double heieht;

    public Cylinder(double radius, double height) {
        super(Math.PI * radius * radius * height, radius);
        this.heieht = height;
    }
}

class Pyramid extends Shape{
    private double height;
    private double s;

    public Pyramid(double height, double s) {
        super(height * s * 4 / 3);
        this.height = height;
        this.s = s;
    }
}

class Box extends Shape {
     private ArrayList<Shape> shapes = new ArrayList<>();
     private double available;

     public Box (double available) {
         super(available);
         this.available = available;

     }

     public  boolean add(Shape shape) {
         if (available >= shape.getVolume()) {
             shapes.add(shape);
             available -= shape.getVolume();
             return true;
         } else {
             return false;
         }
     }
}

public class Main{

    public static void main(String[] args) {
        Ball ball = new Ball(4.5);
        Cylinder cylinder = new Cylinder(2, 2);
        Pyramid pyramid = new Pyramid(100,100);

        Box box = new Box(1000);

        System.out.println(box.add(ball));
        System.out.println(box.add(cylinder));
        System.out.println(box.add(pyramid));
    }
}
