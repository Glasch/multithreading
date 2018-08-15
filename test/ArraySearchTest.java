import com.glasch.multithreading.ArraySearcher;
import com.glasch.multithreading.TestDataGenerator;
import com.glasch.multithreading.count.CountRunner;
import com.glasch.multithreading.count.Counter;
import com.glasch.multithreading.trytoread.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Author: glaschenko
 * Created: 09.08.2018
 */
public class ArraySearchTest extends TestCase {

    public void testArraySearcher() {
        long before = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            int[] array = new TestDataGenerator().generateArray(10000, 6);
            int index = new ArraySearcher().findIndex(array, 6);
            System.out.println("search value index = " + index);
        }
        long after = System.currentTimeMillis();
        System.out.println("time = " + (after - before));

    }

    public void testArraySearchRunner() {
        long before = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            int[] array = new TestDataGenerator().generateArray(10000, 6);
            int index = new ArraySearcher().findIndexParallel(array, 6, 2);
            System.out.println("search value index = " + index);
        }
        long after = System.currentTimeMillis();
        System.out.println("time = " + (after - before));
    }

    public void testArrayCountTest() {
        TestDataGenerator testDataGenerator = new TestDataGenerator();
        int[] list = testDataGenerator.generateRandomArray(100000, 10);
        Counter counter = new Counter();
        int threadsCount = 20;
        countParallel(list, counter, threadsCount);
        System.out.println("Count = " + counter.getCount());
        counter.setCount(new AtomicInteger(0));
        countParallel(list, counter, 1);
        System.out.println("Count = " + counter.getCount());
    }

    private void countParallel(int[] list, Counter counter, int threadsCount) {
        int step = list.length / threadsCount;
        int from = 0;
        int to;
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            to = i == threadsCount - 1 ? list.length : from + step;
            CountRunner countRunner = new CountRunner(counter, list, from, to, 5);
            from = to;
            Thread thread = new Thread(countRunner);
            threads.add(thread);
            thread.start();

        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }


    }

    public void testBookSync(){
        Book book = new BookSynchronized();
        _testBook(book);
    }

    public void testBookRWLock(){
        Book book = new BookRWLock();
        _testBook(book);
    }

    private void _testBook(Book book) {
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<Reader> readers = new ArrayList<>();
        Writer writer = new Writer(book);
        Thread write = new Thread(writer);
        write.start();
        threads.add(write);


        for (int i = 0; i < 10 ; i++) {
            Reader reader = new Reader(book);
            readers.add(reader);
            Thread read = new Thread(reader);
            read.start();
            threads.add(read);

        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
        for (Reader reader : readers) {
            System.out.println(reader.getTotal());
        }
    }
}
