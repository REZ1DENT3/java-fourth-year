package net.babichev.task7;

import java.util.ArrayList;

/**
 * 4,7,5,3,9,11,1,2,10
 */

/**
 *
 *   Используя многопоточную схему решить след задачу :
 *
 *   1. Вычислить сумму элементов массива, используя блочный подход.             ++      --     *
 *   2. Вычислить сумму элементов массива, используя циклический подход.         ++      --     *
 *
 *   3. Вычислить минимальный элемент матрицы, используя блочный подход.         ++      --     *
 *   4. Вычислить максимальный элемент матрицы, используя циклический подход.    ++      --     *
 *
 *   5. Решить слау методом гаусса                                               +       --
 *   6. Реализовать Lu разложение                                                +
 *   7. Реализовать умножение матриц.                                            ++      --
 *
 *   8. На основе программы для решения СЛАУ методом Гаусса напишите             +
 *    параллельную программу для вычисления определителя и постройте
 *    зависимость коэффициента ускорения от числа ядер (потоков).
 *
 *   9. Реализовать транспонирование матрицы n×n.                                +       --
 *
 *   10. Реализовать метод Гаусса (метод элементарных преобразований)            +       --
 *    для вычисления ранга произвольной матрицы A – m×n .
 *
 *   11. Создать 2 вектора с 1000 элементами из случайных чисел.                 +       --
 *    Скалярно умножить эти вектора. Сравнить время
 *    счета параллельного и последовательного алгоритмов.
 *
 */

class Task1 implements Runnable
{
    private ArrayList<ArrayList<Integer>> a;
    public int sum = 0;
    public int i, j, p;
    public Task1(ArrayList<ArrayList<Integer>> a, int p) {
        this.a = a;
        this.i = 0;
        this.j = 0;
        this.p = p;
    }

    public void run() {
//        Вычислить сумму элементов массива, используя блочный подход.
        int p1 = (int)Math.ceil((float)a.size() / this.p);
        int p2 = (int)Math.ceil((float)a.get(0).size() / this.p);
        for (int i = this.i * p1; i < (a.size()) && (i < ((1 + this.i) * p1)); ++i) {
            for (int j = this.j * p2; (j < a.get(i).size()) && (j < ((1 + this.j) * p2)); ++j) {
                this.sum += a.get(i).get(j);
            }
        }
    }
}

class Task2 implements Runnable
{
    private ArrayList<ArrayList<Integer>> a;
    public int sum = 0;
    public int i, j, p;
    public Task2(ArrayList<ArrayList<Integer>> a, int p) {
        this.a = a;
        this.i = 0;
        this.j = 0;
        this.p = p;
    }

    public void run() {
//        Вычислить сумму элементов массива, используя циклический подход.
        for (int j = this.j; j < a.get(this.i).size(); j += 2) {
            sum += a.get(this.i).get(j);
        }
    }
}

class Task3 implements Runnable
{
    private ArrayList<ArrayList<Integer>> a;
    public int min = 999999;
    public int i, j, p;
    public Task3(ArrayList<ArrayList<Integer>> a, int p) {
        this.a = a;
        this.i = 0;
        this.j = 0;
        this.p = p;
    }

    public void run() {
//        Вычислить минимальный элемент матрицы, используя блочный подход.
        int p1 = (int)Math.ceil((float)a.size() / this.p);
        int p2 = (int)Math.ceil((float)a.get(0).size() / this.p);
        for (int i = this.i * p1; i < (a.size()) && (i < ((1 + this.i) * p1)); ++i) {
            for (int j = this.j * p2; (j < a.get(i).size()) && (j < ((1 + this.j) * p2)); ++j) {
                if (this.min > a.get(i).get(j)) this.min = a.get(i).get(j);
            }
        }
    }
}
class Task4 implements Runnable
{
    private ArrayList<ArrayList<Integer>> a;
    public int max = -999999;
    public int i, j, p;
    public Task4(ArrayList<ArrayList<Integer>> a, int p) {
        this.a = a;
        this.i = 0;
        this.j = 0;
        this.p = p;
    }

    public void run() {
//        Вычислить максимальный элемент матрицы, используя циклический подход.
        for (int j = this.j; j < a.get(this.i).size(); j += 2) {
            if (this.max < a.get(this.i).get(j)) this.max = a.get(this.i).get(j);
        }
    }
}

class task5 implements Runnable
{
    public void run() {

    }
}

public class Main {
    public static void main(String[] args) {

        int numberOfLogicalProcessors = Runtime
                .getRuntime()
                .availableProcessors();

        // init array
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        int temp = 1;
        for (int i = 0; i < 5; ++i) {
            ArrayList<Integer> tempArray = new ArrayList<>();
            for (int j = 0; j < 6; ++j) {
                if ((temp / 10) == 1) temp = 1;
                tempArray.add(j, temp++);
                System.out.print(tempArray.get(j) + " ");
            }
            System.out.println();
            array.add(i, tempArray);
        }

        // task 1
        Task1 task1 = new Task1(array, numberOfLogicalProcessors);
        for (int i = 0; i < numberOfLogicalProcessors; ++i) {
            for (int j = 0; j < numberOfLogicalProcessors; ++j) {
                task1.i = i;
                task1.j = j;
                Thread thread = new Thread(task1);
                thread.start();
                try {
                    thread.join();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("sum: " + task1.sum);

        // task 2
        Task2 task2 = new Task2(array, numberOfLogicalProcessors);
        for (int i = 0; i <= ((array.size() - 1) << 1) + 1; ++i) {
            task2.i = i >> 1;
            task2.j = i % 2;
            Thread thread = new Thread(task2);
            thread.start();
            try {
                thread.join();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("sum: " + task2.sum);

        // task 3
        Task3 task3 = new Task3(array, numberOfLogicalProcessors);
        for (int i = 0; i < numberOfLogicalProcessors; ++i) {
            for (int j = 0; j < numberOfLogicalProcessors; ++j) {
                task3.i = i;
                task3.j = j;
                Thread thread = new Thread(task3);
                thread.start();
                try {
                    thread.join();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("min: " + task3.min);

        // task 4
        Task4 task4 = new Task4(array, numberOfLogicalProcessors);
        for (int i = 0; i <= ((array.size() - 1) << 1) + 1; ++i) {
            task4.i = i >> 1;
            task4.j = i % 2;
            Thread thread = new Thread(task4);
            thread.start();
            try {
                thread.join();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("max: " + task4.max);

        /**
         *  13. реализовать программу гонки
         *      с использованием потока и
         *      оконного интерфейса
         */

    }
}
