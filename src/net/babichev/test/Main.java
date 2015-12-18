package net.babichev.test;

public class Main {
    public static void main(String[] argv) {
        for (int i = 1; i < 16; i+=2) {
            for (int j = 1; j < 16; j+=2) {
                for (int k = 1; k < 16; k+=2) {
                    if ((i + j + k) == 30)
                        System.out.println(i + " " + j + " " + k + " - YEAH!!!");
                    else
                        System.out.println(i + " " + j + " " + k);
                }
            }
        }
    }
}
