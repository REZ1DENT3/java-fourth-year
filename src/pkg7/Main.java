package pkg7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Создаем класс для нашего вектора
 *
 * Наследуем класс Thread и пишем конструктор и перегружаем метод run
 */
class MyThread extends Thread
{
    public long sum;

    private int[] a, b;
    private int st, max;

    public MyThread(int[] a, int[] b, int st, int max) {
        this.a = a;
        this.b = b;
        this.st = st;
        this.max = max;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = st; i < st + max; ++i) {
            sum += a[i] * b[i];
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Создаем массивы a, b по 1000 элементов
        int a[] = new int[1000];
        int b[] = new int[a.length];

        // заполняем массив а
        System.out.print("a = ");
        for (int i = 0; i < a.length; ++i) {
            a[i] = (int)(Math.random() * 10);
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // заполняем массив b
        System.out.print("b = ");
        for (int i = 0; i < b.length; ++i) {
            b[i] = (int)(Math.random() * 10);
            System.out.print(b[i] + " ");
        }
        System.out.println();

        // без потоков
        long startTime = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < a.length; ++i) {
            sum += a[i] * b[i];
        }
        long endTime = System.nanoTime() - startTime;

        // ввод кол-во потоков
        int countThread;
        System.out.print("Введите кол-во потоков: ");
        Scanner sc = new Scanner(System.in);
        countThread = sc.nextInt();

        // создаем массив из элементов класса MyThread
        ArrayList<MyThread> list = new ArrayList<>();

        // инициализируем потоки внутри массива
        for (int i = 0; i < countThread; ++i) {
            int c1 = a.length / countThread,
                    c2 = (int)((float)i * (int)((float)a.length / (float)countThread));
            if (i == (countThread - 1)) {
                c1 = a.length - c2;
            }
            list.add(i, new MyThread(a, b, c2, c1));
        }
        long startTimeThread = System.nanoTime();

        long _sum = 0;

        // стартуем все потоки
        for (int i = 0; i < countThread; ++i) {
            list.get(i).start();
        }

        // ожидаем завершения и суммируем результат полученный из потоков
        for (int i = 0; i < countThread; ++i) {
            while (list.get(i).isAlive());
            _sum += list.get(i).sum;
        }

        long endTimeThread = System.nanoTime() - startTimeThread;

        System.out.println("result: " + sum + ", " + _sum);
        System.out.println("time for: " + endTime + "ns");
        System.out.println("time MyThread: " + endTimeThread + "ns");
        try {
            // завершаем потоки
            for (int i = 0; i < countThread; ++i) {
                list.get(i).join();
            }
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}