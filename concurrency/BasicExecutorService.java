package main.java.com.damo.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicExecutorService {
    public static void main(String[] args) {
        final int THREAD=3;
        final int LOOP=3;
        final int TASK=5;

        ExecutorService exec = Executors.newFixedThreadPool(THREAD);

        for(int i=1;i<=TASK;i++){
            Basictask task=new Basictask(i,LOOP);
            exec.submit(task);
        }
            exec.shutdown();
    }

}

class Basictask implements Runnable {
    private int taskId;
    private int loopCount;

    public Basictask(int taskId, int loopCount) {
        this.taskId = taskId;
        this.loopCount = loopCount;
    }

    @Override
    public void run() {
        for(int i= 1;i<=loopCount;i++){
            System.out.println("Task # "+this.taskId+" - iteration #"+i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
