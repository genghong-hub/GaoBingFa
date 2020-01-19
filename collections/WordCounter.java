package main.java.com.damo.collections;

import java.util.HashMap;



public class WordCounter {

    public static void main(String[] args) {
        Integer [] nums ={10,33,11,55,44,35,66,45,33,75,87,5,3,7};
        HashMap<?,Integer> countes1 =wordCount(nums);
        System.out.println(countes1);

        String  str= "Hi Hello Hi hi";
        String [] words =str.split( " ");
        HashMap<?,Integer> counts2= wordCount(words);
        System.out.println(counts2);
    }

    private static <T>HashMap<T,Integer> wordCount(T groups[]) {
        HashMap<T, Integer> map = new HashMap<>();
        for (T key : groups) {
            int value=1;
            if (map.get(key) == null) {

            } else {
                value = (int) map.get(key) + 1;
            }
            map.put(key, value);
        }
        return map;
    }

}
