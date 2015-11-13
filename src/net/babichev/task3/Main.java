package net.babichev.task3;

import java.util.Scanner;

/**
 * Создать абстрактный класс Shape с методами
 * - pub abs double square()
 * - pub abs void init(Scanner scanner)
 * - pub String toString(), Object
 * <p>
 * Построить иерархию классов.
 * Shape    -> Circle
 *          -> Rectangle -> Square
 *          -> Triangle
 */

abstract class Shape extends Object {
    protected double a, b;
    public abstract double square();
    public abstract void init(Scanner scanner);
}

class Circle extends Shape {
    public double square() {
        return Math.PI * this.a * this.b;
    }

    public void init(Scanner scanner) {
        System.out.println(this.toString());
        System.out.print("Input r: ");
        if (scanner.hasNextDouble()) {
            this.a = scanner.nextDouble();
        }
        this.b = this.a;
    }
}

class Rectangle extends Shape {
    public double square() {
        return this.a * this.b;
    }

    public void init(Scanner scanner) {
        System.out.println(this.toString());
        System.out.print("Input a: ");
        if (scanner.hasNextDouble()) {
            this.a = scanner.nextDouble();
        }

        System.out.print("Input b: ");
        if (scanner.hasNextDouble()) {
            this.b = scanner.nextDouble();
        }
    }
}

class Square extends Rectangle {
    public void init(Scanner scanner) {
        System.out.println(this.toString());
        System.out.print("Input a: ");
        if (scanner.hasNextDouble()) {
            this.a = scanner.nextDouble();
        }
        this.b = this.a;
    }
}

class Triangle extends Shape {
    public double square() {
        return this.a * this.b / 2;
    }

    public void init(Scanner scanner) {
        System.out.println(this.toString());
        System.out.print("Input a: ");
        if (scanner.hasNextDouble()) {
            this.a = scanner.nextDouble();
        }

        System.out.print("Input h: ");
        if (scanner.hasNextDouble()) {
            this.b = scanner.nextDouble();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Circle circle = new Circle();
        circle.init(sc);
        System.out.println("Circle S: " + circle.square());

        Rectangle rectangle = new Rectangle();
        rectangle.init(sc);
        System.out.println("Rectangle S: " + rectangle.square());

        Square square = new Square();
        square.init(sc);
        System.out.println("Square S: " + square.square());

        Triangle triangle = new Triangle();
        triangle.init(sc);
        System.out.println("Triangle S: " + triangle.square());

    }
}
