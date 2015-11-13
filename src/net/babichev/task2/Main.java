package net.babichev.task2;

import net.babichev.libs.math;

import java.util.ArrayList;

/**
 * Создать базовый класс со свойствами:
 * - дальность
 * - вместимость
 * - скорость
 * и методами для рассчёта грузопотока в сутки в зависимости от растояния.
 * <p>
 * Программно заполнить массив созданными объектами (разными). Размер массива 100 элементов.
 * Упорядочить масств по возрастанию стоимости перевозки и вывести элементы на экран в виде:
 * - #
 * - тип
 * - наименование
 * - дальность
 * - вместимость
 * - скорость
 * - цена
 * - цена за кг
 */

class Base {
    private double distance, capacity, speed;

    public Base(double distance, double capacity, double speed) {
        this.distance = distance;
        this.capacity = capacity;
        this.speed = speed;
    }

    public double getDays() {
        try {
            return this.getSpeed() * this.getCapacity() / this.getDistance();
        } catch (Exception e) {}
        return -1.0;
    }

    public double getDistance() {return distance;}
    public void setDistance(double distance) {this.distance = distance;}

    public double getCapacity() {return capacity;}
    public void setCapacity(double capacity) {this.capacity = capacity;}

    public double getSpeed() {return speed;}
    public void setSpeed(double speed) {this.speed = speed;}
}

class NewBase extends Base {

    private String name, type;
    private int cost;

    public NewBase(double distance, double capacity, double speed, String name, String type, int cost) {
        super(distance, capacity, speed);
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    public double getPrice() {
        try {
            return (this.getCost() * getDays()) / 24;
        } catch (Exception e) {}
        return -1.0;
    }

    public double getPriceW() {
        return this.getPrice() / this.getCapacity();
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public int getCost() {return cost;}
    public void setCost(int cost) {this.cost = cost;}

    public final void print() {
        System.out.printf("%6s", this.getType() + "\t");
        System.out.printf("%13s", this.getName() + "\t");
        System.out.printf("%10.2f\t", this.getDistance());
        System.out.printf("%10.2f\t", this.getCapacity());
        System.out.printf("%10.2f\t", this.getSpeed());
        System.out.printf("%10.2f\t", this.getPrice());
        System.out.printf("%10.2f\t", this.getPriceW());
    }
}

public class Main {

    public static ArrayList<NewBase> bases = new ArrayList<>(100);

    public static int partition(int left, int right) {
        int i = left, j = right;
        NewBase tmp;
        int position = (left + right) / 2;
        double pivot = bases.get(position).getPriceW();

        while (i <= j) {
            while (bases.get(i).getPriceW() < pivot) i++;
            while (bases.get(j).getPriceW() > pivot) j--;
            if (i <= j) {
                tmp = bases.get(i);
                bases.set(i, bases.get(j));
                bases.set(j, tmp);
                i++;
                j--;
            }
        }
        ;

        return i;
    }

    public static void quickSort(int left, int right) {
        int index = partition(left, right);
        if (left < index - 1)
            quickSort(left, index - 1);
        if (index < right)
            quickSort(index, right);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; ++i) {
            bases.add(i, new NewBase(
                    math.randDouble(5000, 10000),
                    math.randDouble(45000, 110000),
                    math.randDouble(40, 110),
                    "bk" + i,
                    "type" + math.getIntRand(i),
                    math.randInt(100000, 1000000)
            ));
        }
        quickSort(0, 99);
        System.out.println("#\tтип\t\tнаименование\tдальность\tвместимость\t\tскорость\tцена\t\tцена за кг");
        for (int i = 0; i < 100; ++i) {
            System.out.print(i + "\t");
            bases.get(i).print();
            System.out.println();
        }
    }
}
