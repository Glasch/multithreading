package com.glasch.multithreading.trytoread;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * Author: glaschenko
 * Created: 16.08.2018
 */
public class BookRWLock implements Book {
    private ArrayList<Integer> book = new ArrayList<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public int sum() {
        lock.readLock().lock();
        try {
            sleep(10);
            int sum = 0;
//            for (Integer integer : book) {
//                sum += integer;
//            }
            sum = 5;
            return sum;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addToBook(int value) {
        lock.writeLock().lock();
        try {
            sleep(10);
            book.add(value);
        } finally {
            lock.writeLock().unlock();
        }
    }


    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
