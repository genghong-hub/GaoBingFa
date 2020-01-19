package main.java.com.damo.concurrency;

import javax.sql.rowset.CachedRowSet;
import java.util.concurrent.*;

public class CallableExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        Callabletask t = new Callabletask(1);

        Future<Integer> st=exec.submit(t);

        Integer result =st.get();
        System.out.println("Task's total sleep time: " + result + " second");

        exec.shutdown();
    }
}


class Callabletask implements Callable<Integer>{
    private  int taskId;

    public Callabletask(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }

    @Override
    public Integer call() throws Exception{
        int total =taskId;
        System.out.println("Task #"+ this.taskId);
        Thread.sleep(5000);

        total +=taskId;

        return total;
    }


}