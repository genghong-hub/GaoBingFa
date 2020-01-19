package main.java.com.damo.collections;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for(int  i=0;i<5;i++){
            list.add(i);
        }

        for (Integer aList : list) {
            int i = (int) aList;
            System.out.print(i + " ");
        }
        System.out.println("\n"+list);

        Iterator<Integer> iterator =list .iterator();
        while(iterator.hasNext()){
            int x =(int) iterator.next();
            if(x % 2==0){
                iterator.remove();
            }
        }
        System.out.println(list);

        iterator =list.iterator();
        while(iterator.hasNext()){
            int x =(int) iterator.next();
            System.out.print(x+" ");
        }
    }

}
