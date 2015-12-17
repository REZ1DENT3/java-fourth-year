package net.babichev.graph;

import java.util.ArrayList;

class Unit {

    public int lvl, weight;

    public Unit(int lvl, int weight) {
        this.lvl = lvl;
        this.weight = weight;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class Graph {
    private ArrayList<ArrayList<Unit>> graph;
}

public class Main {

    public static void main(String[] args) {

    }

}
