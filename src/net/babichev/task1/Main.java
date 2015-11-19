package net.babichev.task1;

 /**19.	Описать класс «список».
        Предусмотреть возможность добавления и удаления элементов в начало, конец списка, в указанную позицию,
        сортировку по убыванию и возрастанию,
        подсчет количества элементов в списке,
        вывод на экран части списка с указанием границ вывода.
  */

/**
 * push / pop - стек
 * first() +
 * firstRemove() +
 * last() +
 * lastRemove() +
 * remove() +
 * insert() +
 * count() +
 * sortDescending() +
 * sortAscending() +
 * each(ind, end) +
 */

import net.babichev.libs.myList;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        myList list = new myList();

        list.push(2000);
        list.push(1000);
        list.push(3000);

        list.each(0, list.count());

        Random randomGenerator = new Random();
        for (int i = 0; i < 2; ++i) {
            list.push( net.babichev.libs.math.getIntRand(i) );
        }

        list.each(0, list.count());

        list.insert(2, 9999);
        list.each(0, list.count());

        list.sortAscending();
        list.each(0, list.count());

        list.remove(1);
        list.each(0, list.count());

        list.sortDescending();
        list.each(0, list.count());

        System.out.println(list.first());
        System.out.println(list.last());

        list.lastRemove();
        list.each(0, list.count());

        list.firstRemove();
        list.each(0, list.count());

    }
}
