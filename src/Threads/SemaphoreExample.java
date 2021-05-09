package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        
        Connection connection = Connection.getConnection();
        for(int i=0; i<200; i++){
            executorService.submit(()->{
                try {
                    connection.work();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
        }
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.DAYS);
        }
    }
    

class Connection{
    
    private static Connection connection = new Connection();
    private int connectionsCount = 0;
    private Semaphore semaphore = new Semaphore(10);
    
    private Connection(){}
            
    public static Connection getConnection(){
        return connection;
    }
    
    public void work() throws InterruptedException{
        semaphore.acquire();
        try{
            doWork();
        }finally{
            semaphore.release();
        }
    }
    
    private void doWork() throws InterruptedException{
        synchronized(this){
            connectionsCount++;
            System.out.println("connectionsCount = " + connectionsCount);
        }
        Thread.sleep(5000);
        
        synchronized(this){
            connectionsCount--;
        }
    }
    
}