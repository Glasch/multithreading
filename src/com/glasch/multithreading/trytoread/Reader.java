package com.glasch.multithreading.trytoread;

/*
 * Author: glaschenko
 * Created: 15.08.2018
 */
public class Reader implements Runnable{
    Book book;
    private  int readsCount = 0;

    public Reader(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        while (!book.getFinished()){
            readsCount++;
            book.sum();
        }
    }

    public int getReadsCount() {
        return readsCount;
    }
}
