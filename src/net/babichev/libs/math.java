package net.babichev.libs;

import java.util.Random;

/**
 * Created by REZ1DENT3 on 12.11.2015.
 */
public class math {
    private static Random randomGenerator = new Random();

    public static final int getIntRand(int ind) {
        return randomGenerator.nextInt( (ind + 2) << 2 );
    }
}
