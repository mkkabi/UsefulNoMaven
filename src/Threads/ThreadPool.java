package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    
    public static void main(String[] args) throws InterruptedException {
        // executorService creates a Pool of Threads to be used for execution of a task
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // adding new tasks to the threads we created with executorService
        for (int i = 0; i<5; i++){
            // accepts an object of class that implements Runnable
            executorService.submit(new Work(i));
        }
        // shutdown method means that we stop accepting new tasks and proceed to the tasks execution
        executorService.shutdown();
        System.out.println("All tasks submitted");
        
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}


class Work implements Runnable{
    private int id;

    public Work(int id) {
        this.id = id;
    }
    
    @Override
    public void run() {
        try{
            Thread.sleep(50);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Work" + id + " was completed");
    }
    
}