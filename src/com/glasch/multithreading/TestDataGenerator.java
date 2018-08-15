package com.glasch.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Author: glaschenko
 * Created: 09.08.2018
 */
public class TestDataGenerator {

    public int[] generateArray(int size, int searchValue){
        int[] testArray = new int[size] ;
        for (int i = 0; i < size - 1 ; i++) {
            testArray[i] = 0;
        }
        Random random = new Random(555);
        int index = random.nextInt(size);
        testArray[index] = searchValue;

        return testArray;
    }

    public int[] generateRandomArray(int size, int bound){
        int[] testArray = new int[size] ;
        Random random = new Random(555);
        for (int i = 0; i < size - 1 ; i++) {
            testArray[i] = random.nextInt(bound);
        }

        return testArray;
    }



}
