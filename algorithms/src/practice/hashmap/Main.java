package practice.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // HashMap
        Map<String, Integer> map = new HashMap<>();
        // add key-value
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        // see
        System.out.println("apple value: " + map.get("Apple"));
        // remove
        map.remove("Apple");
        // check
        boolean hasApple = map.containsKey("Apple");
        System.out.println(hasApple);
        // print key-value all
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // lambda
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
