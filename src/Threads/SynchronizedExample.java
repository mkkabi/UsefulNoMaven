package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SynchronizedExample {

    public static void main(String[] args) {
        WorkerSynchronized worker = new WorkerSynchronized();
        worker.main();
    }
}

class WorkerSynchronized {

    Object object1 = new Object();
    Object object2 = new Object();

    Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {
        synchronized (object1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
            list1.add(random.nextInt(100));
        }
    }

    public void addToList2() {
        synchronized (object2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
            list2.add(random.nextInt(100));
        }
    }

    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {

        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(WorkerSynchronized.class.getName()).log(Level.SEVERE, null, ex);
        }

        long after = System.currentTimeMillis();

        System.out.println("execution time " + (after - before));

        System.out.println("list1 size " + list1.size());
        System.out.println("list2 size " + list2.size());
    }

}
