package com.glasch.multithreading.trytoread;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * Author: glaschenko
 * Created: 15.08.2018
 */
public class Book {
    private ArrayList<Integer> book = new ArrayList<>();
    private Boolean finished = false;

    synchronized int sum() {
        sleep();
        int sum = 0;
        for (Integer integer : book) {
            sum += integer;
        }
        return sum;
    }

    private void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    synchronized void addToBook(int value) {
        sleep();
        book.add(value);
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Boolean getFinished() {
        return finished;
    }
}
