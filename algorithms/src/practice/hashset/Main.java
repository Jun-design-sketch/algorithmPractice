package practice.hashset;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // make HashSet object
        Set<String> set = new HashSet<>();
        // calculate.add element: set values
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Apple"); // 重複したものは入らない
        System.out.println("test");
        StringBuilder sb = new StringBuilder();
        for(String fruit: set){
            sb.append(fruit+" ");
        }
        System.out.println(sb);
        // remove element
        set.remove("Banana");
        boolean hasBanana = set.contains("Banana");
        System.out.println(hasBanana);
        // size
        System.out.println(set.size());
        // clean
        set.clear();
        System.out.println(set.isEmpty());
    }
}
