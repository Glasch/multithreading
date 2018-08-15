package com.glasch.multithreading;

/*
 * Author: glaschenko
 * Created: 09.08.2018
 */
public class ArraySearchRunner implements  Runnable {

    private int[] list;
    private int searchValue;
    private int startIndex;
    private int endIndex;
    private int result = -1;

    public ArraySearchRunner(int[] list, int searchValue, int startIndex, int endIndex) {
        this.list = list;
        this.searchValue = searchValue;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": runner started for " + startIndex + " - " + endIndex);
        result = ArraySearcher.findIndex(list, searchValue, startIndex, endIndex);
        System.out.println(Thread.currentThread().getName() + ": runner finished for " + startIndex + " - " + endIndex);
    }

    public int getResult() {
        return result;
    }


}
