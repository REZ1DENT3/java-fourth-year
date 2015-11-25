package net.babichev.task4;

/**
 * 10.	Определить класс самолет, экземпляры которого имеют поля
 *      марка,
 *      объем топливного бака,
 *      максимальная дальность полета.
 * Определить функции назначения и изменения полей и
 * функцию вывода на экран.
 *
 * Определить производный	 класс – пассажирский самолет,
 * экземпляры которого имеют поле количество посадочных мест.
 * Определить функцию вывода на экран.
 *
 * Определить функцию переназначения количества мест.
 */

class Airplane extends Object {

    protected float maxRange;
    protected String stamp;
    protected int fuel;

    public Airplane(float maxRange, String stamp, int fuel) {
        this.maxRange = maxRange;
        this.stamp = stamp;
        this.fuel = fuel;
    }

    public final float getMaxRange() { return this.maxRange; }
    public final void setMaxRange(float maxRange) { this.maxRange = maxRange; }
    public final void printMaxRange() { System.out.println(this.toString() + ": " + this.maxRange); }

    public final String getStamp() { return this.stamp; }
    public final void setStamp(String stamp) { this.stamp = stamp; }
    public final void printStamp() { System.out.println(this.toString() + ": " + this.stamp); }

    public final int getFuel() { return this.fuel; }
    public final void setFuel(int fuel) { this.fuel = fuel; }
    public final void printFuel() { System.out.println(this.toString() + ": " + this.fuel); }

    public void allDataPrint() { this.printFuel(); this.printMaxRange(); this.printStamp(); }
}

class PassengerPlane extends Airplane {

    protected int places;
    public PassengerPlane(float maxRange, String stamp, int fuel, int places) {
        super(maxRange, stamp, fuel);
        this.places = places;
    }

    public final int getPlaces() { return this.places; }
    public final void setPlaces(int places) { this.places = places; }
    public final void printPlaces() { System.out.println(this.toString() + ": " + this.places); }

    @Override
    public final void allDataPrint() {
        super.allDataPrint();
        this.printPlaces();
    }

}

public class Main {
    public static void main(String[] args) {
        Airplane a = new Airplane(6500, "Airbus A330", 400);
        a.allDataPrint();

        System.out.println();

        PassengerPlane airbus = new PassengerPlane(5500, "Airbus A320", 360, 330);
        airbus.allDataPrint();
    }
}
