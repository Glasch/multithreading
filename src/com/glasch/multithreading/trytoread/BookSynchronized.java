package com.glasch.multithreading.trytoread;

import java.util.ArrayList;

/*
 * Author: glaschenko
 * Created: 15.08.2018
 */
public class BookSynchronized implements Book{
    private ArrayList<Integer> book = new ArrayList<>();

    public synchronized int sum() {
        sleep();
        int sum = 0;
//            for (Integer integer : book) {
//                sum += integer;
//            }
        sum = 5;
        return sum;
    }

    public synchronized void addToBook(int value) {
        sleep();
        book.add(value);
    }


    private void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
