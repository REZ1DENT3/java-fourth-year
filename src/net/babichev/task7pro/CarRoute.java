package net.babichev.task7pro;

public class CarRoute extends Thread {

    private Model car;

    private long[] dimensions;

    public CarRoute(Model car) {
        this.car = car;
    }

    public final Model getCar() {
        return car;
    }

    public final long[] getDimensions() {
        return dimensions;
    }

    @Override
    public final void run() {
        int n = 100;
        int m = 10;
        int s = 0;
        dimensions = new long[n * m];
        long nanoTime;
        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < m; ++y) {
                nanoTime = System.nanoTime();
                car.f(x, y);
                dimensions[s++] = System.nanoTime() - nanoTime;
            }
        }
        car.setDimensions(dimensions);
    }
}