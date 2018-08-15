package com.glasch.multithreading.trytoread;

import java.util.Random;

/*
 * Author: glaschenko
 * Created: 15.08.2018
 */
public class Writer implements Runnable {
    private Book book;

    public Writer(Book book) {
        this.book = book;
    }

    @Override
    public void run() {

        Random random = new Random(666);
        for (int i = 0; i < 10; i++) {
            book.addToBook(random.nextInt());
        }
//        book.setFinished(true);
    }
}
