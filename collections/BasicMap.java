package main.java.com.damo.collections;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class BasicMap {
    public static void main(String[] args) {
        Map<String,String > data = new HashMap<>();
        data.put("A","A");
        data.put("B","B");
        data.put(null,"C");
        data.put("A","A");
        data.put("D","D");

        System.out.println(data);

        String  value= data.get(null);
        System.out.println("Key = null,Value = "+value);

        value = data.getOrDefault("M","Default");
        System.out.println("Key = null,Value = "+value);



        boolean keyExists = data.containsKey(null);
        boolean valueExists = data.containsValue(null);
        System.out.println(keyExists+" "+valueExists );

        System.out.println("data map size is "+data.size());

        Set<Entry<String ,String>> entrySet =data.entrySet();
        System.out.println(entrySet);

        Set<String> keyset =data.keySet();
        System.out.println("data keys = "+keyset);

        Collection<String>  values= data.values();
        System.out.println(""+values);

        data.clear();
        System.out.println("data map is empty = "+data.isEmpty());

    }
}
