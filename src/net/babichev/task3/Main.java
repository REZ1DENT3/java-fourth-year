package net.babichev.task3;

import java.util.Scanner;

/**
 * Создать абстрактный класс Shape с методами
 * - pub abs double square()
 * - pub abs void init(Scanner scanner)
 * - pub String toString(), Object
 * <p>
 * Построить иерархию классов.
 * Shape -> Circle
 * -> Rectangle -> Square
 * -> Triangle
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
    public double square() {
        return 0;
    }

    public void init(Scanner scanner) {

    }
}

class Square extends Rectangle {
    public double square() {
        return 0;
    }

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


}
