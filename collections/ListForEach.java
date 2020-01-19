package main.java.com.damo.collections;

import java.awt.peer.ChoicePeer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ListForEach {
    class MyConsumer implements Consumer<Object> {
        @Override
        public void accept(Object o) {
            System.out.println("Processed...");
        }
    }

    public static void main(String[] args) {
        List<String> stocks = new ArrayList<>();
        stocks.add("Alibaba");
        stocks.add("Mi");
        stocks.add("Tecent");
        stocks.add("MT");

        Consumer<Object> consumer =new ListForEach().new MyConsumer();

        stocks.forEach(consumer);
        stocks.forEach(x-> System.out.println("Processed " + x));
    }
}
