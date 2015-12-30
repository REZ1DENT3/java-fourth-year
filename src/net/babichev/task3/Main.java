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
 * -> Rectangle -> Square
 * -> Triangle
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

    public double longCircle() {
        return Math.PI * 2 * this.a;
    }

    public double sector(int n0) {
        return this.longArch(n0) * this.a / 2;
    }

    public double longArch(int n0) {
        return (Math.PI * this.a) / 180 * n0;
    }

    public double diameter() {
        return this.a * 2;
    }

    public double spd() {
        return 1 / 4 * Math.PI * Math.pow(this.diameter(), 2);
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

    public double p() {
        return 2 * (this.a + this.b);
    }

    public double d() {
        return Math.sqrt(this.a * this.a + this.b * this.b);
    }

    public double r() {
        return 1 / 2 * this.d();
    }

    public double s(double phi) {
        return this.r() * this.d() * Math.sin(phi);
    }

    public double ss() {
        return Math.cosh(this.d());
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

    public double pp() {
        return this.a * 4;
    }

    public double dd() {
        return this.a * Math.sqrt(2);
    }

    public double sss() {
        return Math.pow(this.dd(), 2) / 2;
    }

    public double R() {
        return Math.sqrt(2) / 2 * this.a;
    }

    public double RR() {
        return this.dd() / 2;
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

    public double c2() {
        return this.a * this.a + this.b * this.b;
    }

    public double c() {
        return Math.sqrt(this.c2());
    }

    public double R() {
        return this.c() / 2;
    }

    public double ac() {
        return Math.pow(this.a, 2) / this.c();
    }

    public double bc() {
        return Math.pow(this.b, 2) / this.c();
    }

    public double h() {
        return Math.sqrt(this.bc() * this.ac());
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
