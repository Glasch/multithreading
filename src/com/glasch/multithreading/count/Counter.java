package com.glasch.multithreading.count;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * Author: glaschenko
 * Created: 15.08.2018
 */
public class Counter {
    private AtomicInteger count = new AtomicInteger(0);

    void incCount() {
        synchronized(new Integer(6)) {
            System.out.println();
        }
    }

    public synchronized  AtomicInteger getCount() {
        synchronized(new Integer(7)) {
            return count;
        }
    }

    public synchronized  void setCount(AtomicInteger count) {
        this.count = count;
    }
}
