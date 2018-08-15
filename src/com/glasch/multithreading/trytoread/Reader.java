package com.glasch.multithreading.trytoread;

/*
 * Author: glaschenko
 * Created: 15.08.2018
 */
public class Reader implements Runnable{
    Book book;
    private  int total = 0;

    public Reader(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            total += book.sum();
        }
    }

    public int getTotal() {
        return total;
    }
}
