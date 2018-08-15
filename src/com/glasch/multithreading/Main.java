package com.glasch.multithreading;

/*
 * Author: glaschenko
 * Created: 09.08.2018
 */
public class Main {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        for (int i = 0; i < 9 ; i++) {
            int[] array = new TestDataGenerator().generateArray(500000000, 6);
            int index = new ArraySearcher().findIndex(array, 6);
            System.out.println("search value index = " + index);
        }
        long after = System.currentTimeMillis();
        System.out.println( "time = " + (after-before));
    }
}
