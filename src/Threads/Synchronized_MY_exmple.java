package Threads;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Synchronized_MY_exmple {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Worker worker = new Worker(list);

        worker.work(400);
    }

}

class Worker {

    List<Integer> list;

    public Worker(List<Integer> list) {
        this.list = list;
    }

    private void add(int numberOfAdditions) {
        Random rand = new Random();
        for (int i = 0; i < numberOfAdditions; i++) {
            synchronized (this) {
                list.add(rand.nextInt(100));
            }
            try {
                sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void work(int numberOfIterations) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                add(numberOfIterations / 4);
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);

        long before = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis();

        System.out.println("time to run " + (after - before));
        System.out.println("array size " + list.size());

    }

}