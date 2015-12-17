package pkg7;

class thread extends Thread
{
    public long sum = 0;

    private int[] a, b;
    private int st;

    public thread(int[] a, int[] b, int st) {
        this.a = a;
        this.b = b;
        this.st = st;
    }

    @Override
    public void run() {
        int s = a.length / 2;
        for (int i = 0; i < s; ++i) {
            int ind = st + i;
            sum += a[ind] * b[ind];
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int a[] = new int[1000];
        int b[] = new int[a.length];

        System.out.print("a = ");
        for (int i = 0; i < a.length; ++i) {
            a[i] = (int)(Math.random() * 10);
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.print("b = ");
        for (int i = 0; i < b.length; ++i) {
            b[i] = (int)(Math.random() * 10);
            System.out.print(b[i] + " ");
        }
        System.out.println();

        long startTime = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < a.length; ++i) {
            sum += a[i] * b[i];
        }
        long endTime = System.nanoTime() - startTime;

        thread t1 = new thread(a, b, 0);
        thread t2 = new thread(a, b, a.length / 2);

        long startTimeThread = System.nanoTime();

        long _sum = 0;

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive());

        _sum = t1.sum + t2.sum;

        long endTimeThread = System.nanoTime() - startTimeThread;

        System.out.println("result: " + sum + ", " + _sum);
        System.out.println("time for: " + endTime + "ns");
        System.out.println("time thread: " + endTimeThread + "ns");
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}