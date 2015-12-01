package net.babichev.libs;

import java.util.ArrayList;

public class MyClassList {

    private ArrayList<Integer> _list = new ArrayList<Integer>();
    private int _count = 0;

    private static final int first = 0;

    public MyClassList() {}

    public int count() {
        return this._count;
    }

    public void push(Integer t) {
        _list.add(this._count++, t);
    }

    public Integer pop() {
        Integer t = this.at(--this._count);
        this._list.remove(this._count);
        return t;
    }

    private Integer at(int ind) {
        return this._list.get(ind);
    }

    public void insert(int ind, Integer data) {
        this._list.add(ind, data); // 9999
        this._count++;
    }

    public Integer last() {
        return this.at(this._count - 1);
    }

    public void lastRemove() {
        this._list.remove(--this._count);
    }

    public Integer first() {
        return this.at(first);
    }

    public void firstRemove() {
        for (int i = 1; i < this._count; i++) {
            this._list.set(i - 1, this.at(i));
        }
        lastRemove();
    }

    public void remove(int ind) {
        this._list.remove(ind);
        this._count--;
    }

    public void each(int ind, int end) {
        System.out.println("--------------");
        for (int i = ind; i <= end && i < this._count; i++) {
            System.out.println(i + " " + this.at(i));
        }
        System.out.println("--------------");
    }

    int partition(int left, int right, int type) {
        int i = left, j = right;
        int tmp;
        int pivot = this.at((left + right) / 2);

        while (i <= j) {
            if (type == 0) {
                while (this.at(i) < pivot) i++;
                while (this.at(j) > pivot) j--;
            }
            else {
                while (this.at(i) > pivot) i++;
                while (this.at(j) < pivot) j--;
            }
            if (i <= j) {
                tmp = this.at(i);
                this._list.set(i++, this.at(j));
                this._list.set(j--, tmp);
            }
        }
        ;

        return i;
    }

    void quickSort(int left, int right, int type) {
        int index = partition(left, right, type);
        if (left < index - 1)
            quickSort(left, index - 1, type);
        if (index < right)
            quickSort(index, right, type);
    }

    public void sortDescending() {
        quickSort(first, this._count - 1, 0);
    }

    public void sortAscending() {
        quickSort(first, this._count - 1, 1);
    }

}
