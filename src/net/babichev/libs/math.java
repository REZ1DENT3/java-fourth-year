package net.babichev.libs;

import java.util.Random;

public class math {
    private static Random randomGenerator = new Random();

    public static final int getIntRand(int ind) {
        return randomGenerator.nextInt( (ind + 2) << 2 );
    }

    public static final int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static final double randDouble(int min, int max) {
        Random r = new Random();
        return min + r.nextDouble() * max;
    }
}