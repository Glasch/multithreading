package com.glasch.multithreading.count;

/*
 * Author: glaschenko
 * Created: 15.08.2018
 */
public class CountRunner implements Runnable {
    private Counter counter;
    private int[] list;
    int from;
    int to;
    int searchValue;

    public CountRunner(Counter counter, int[] list, int from, int to, int searchValue) {
        this.counter = counter;
        this.list = list;
        this.from = from;
        this.to = to;
        this.searchValue = searchValue;
    }

    @Override
    public void run() {
        for (int i = from; i < to ; i++) {
            if (list[i]==searchValue){
                counter.getCount().incrementAndGet();
            }
        }
    }
}
