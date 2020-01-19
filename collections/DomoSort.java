package main.java.com.damo.collections;

import main.java.com.damo.concurrency.Sync1;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class QuickSort {
    private static int partition(Long[] numbers, int low, int high) {
        Long soldier = numbers[low];
        while (low < high) {
            while(low < high){
                if(numbers[high] < soldier){
                    numbers[low] = numbers[high];
                }
                high --;
            }
            while(low < high){
                if(numbers[low] > soldier){
                    numbers[high]  = numbers[low];
                }
                low ++;
            }
        }
        numbers[low] = soldier;
        return  low;
    }
    public static void qsort(Long[] numbers, int low,int high){
        if(low < high){
            int soldier = partition (numbers,low,high);
            qsort (numbers,low,soldier - 1);
            qsort (numbers,soldier + 1,high);
        }
    }
}
class  ParallelQuickSort extends RecursiveAction {
    private Long[] numbers;
    private int low;
    private int high;
    private int threshold =30;

    public ParallelQuickSort(Long[] numbers, int threshold) {
        this.numbers = numbers;
        this.low = 0;
        this.high = numbers.length - 1;
        this.threshold = threshold;
    }

    public ParallelQuickSort(Long[] numbers, int low, int high) {
        this.numbers = numbers;
        this.low = low;
        this.high = high;
    }
    private static int partition(Long[] numbers, int low, int high) {
        Long soldier = numbers[low];
        while (low < high) {
            while(low < high){
                if(numbers[high] < soldier){
                    numbers[low] = numbers[high];
                }
                high --;
            }
            while(low < high){
                if(numbers[low] > soldier){
                    numbers[high]  = numbers[low];
                }
                low ++;
            }
        }
        numbers[low] = soldier;
        return  low;
    }


    @Override
    protected void compute() {
        if(high - low < threshold){
            QuickSort.qsort (numbers,low,high);
        }else{
            int soldier = partition (numbers,low,high);
            ParallelQuickSort left = new ParallelQuickSort (numbers,low,soldier -1);
            ParallelQuickSort right = new ParallelQuickSort (numbers,soldier +1,high);
            invokeAll (left,right);

        }
    }
}
public class DomoSort {

    private  static void P(String str){
        System.out.println (str);
    }

    private  static Long[]  getLongNumbers(int n){
        Random random = new Random ();
        Long []  numbers = new Long[n];

        for(int i = 0;i < n;i++){
            Long num =random.nextLong ();
            if(num < 0){
                num = Math.abs (num);
            }
            numbers[i] = num;
        }
        return numbers;
    }



    public static void main(String[] args) {
        final int RUN_TIMES = 10;
        final int SORT_NUM = 1000;
        final int THRESHOLD = 36200;

        long startTime;

        for(int i=1;i <= RUN_TIMES;i++){
            P("The " + i + "  run:" );
            P("Generating " + SORT_NUM + " numbera" );

            P("QUICK SORT");
            Long[] qsnums = getLongNumbers (SORT_NUM);
            startTime = System.currentTimeMillis ();
            QuickSort.qsort (qsnums,0,qsnums.length - 1);
            long qsRunTime = System.currentTimeMillis () - startTime;
            P("Total use: " + qsRunTime + "  ms" );


//            P("PARALLEL QUICK SORT");
//            Long[]  pqsNums = getLongNumbers (SORT_NUM);
//            ForkJoinPool pool = new ForkJoinPool ();
//            ParallelQuickSort pqs = new ParallelQuickSort (pqsNums,THRESHOLD);
//            startTime = System.currentTimeMillis ();
//            pool.execute (pqs);
//            while(!pqs.isDone()){}
//            Long pqsRuntime = System.currentTimeMillis () - startTime;
//            P("Total use: " + pqsRuntime + " ms" );
        }
    }
}
