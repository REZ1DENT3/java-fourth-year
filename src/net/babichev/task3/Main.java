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
    public abstract double square();
    public abstract void init(Scanner scanner);
}

class Circle extends Shape {
    public double square() {
        return 0;
    }

    public void init(Scanner scanner) {

    }
}

class Rectangle extends Shape {
    private double a, b;
    public double square() {
        return a * b;
    }

    public void init(Scanner scanner) {

    }
}

class Square extends Rectangle {
    public void init(Scanner scanner) {

    }
}

class Triangle extends Shape {
    public double square() {
        return 0;
    }

    public void init(Scanner scanner) {

    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double x = 0., y = 0.;
        if (sc.hasNextDouble()) {
            x = sc.nextDouble();
        }

        if (sc.hasNextDouble()) {
            y = sc.nextDouble();
        }

        System.out.println(x);
        System.out.println(y);

    }
}
