package com.glasch.multithreading;

import java.util.*;

/*
 * Author: glaschenko
 * Created: 09.08.2018
 */
public class ArraySearcher {

    public int findIndex(int[] list, int searchValue){
      return findIndex(list, searchValue, 0, list.length);
    }

    public int findIndexParallel(int[] list, int searchValue, int threadsCount){
        Map<Thread, ArraySearchRunner> threads = new HashMap<>(threadsCount);
        int step = list.length/threadsCount;
        int startIndex = 0;
        for (int i = 0; i < threadsCount ; i++) {
            ArraySearchRunner arraySearchRunner = new ArraySearchRunner(list,searchValue,startIndex,startIndex+step);
            Thread thread = new Thread(arraySearchRunner);
            thread.start();
            startIndex += step;
            threads.put(thread,arraySearchRunner);
        }
        while(true){
            for (ArraySearchRunner searchRunner : threads.values()) {
                if(searchRunner.getResult() >= 0){
                    return searchRunner.getResult();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
        }
//        for (Thread thread : threads.keySet()) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                throw new IllegalStateException();
//            }
//            int result = threads.get(thread).getResult();
//            if (result!=-1){
//                return result;
//            }
//        }
//       return  -1;
    }

    static int findIndex(int[] list, int searchValue, int startIndex, int endIndex){
        for (int i = startIndex; i < endIndex  ; i++) {
            if (list[i]==searchValue){
                return i;
            }
        }
        return  -1;
    }


}
