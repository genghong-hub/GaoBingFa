package main.java.com.damo.concurrency;

public class Sync1 implements  Runnable {
    static int  a = 0;
    static  Sync1 t=new Sync1();

    @Override
    public void run(){
        for(int j=0;j<10000000;j++){
            synchronized (t){
            a++;}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 =new Thread(t);
        Thread t2 =new Thread(t);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(a);
    }
}
