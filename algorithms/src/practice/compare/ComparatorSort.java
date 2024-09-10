package practice.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorSort {
    public static void main(String[] args) {
        Comparator<MyInteger2> comp = new Comparator<MyInteger2>() {
            @Override
            public int compare(MyInteger2 o1, MyInteger2 o2) {
                return o1.value - o2.value;
            }
        };

        MyInteger2[] arr = new MyInteger2[10];
        for(int i=0; i<10; i++){
            arr[i] = new MyInteger2((int)(Math.random()*100));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            sb.append(arr[i].value+" ");
        }
        sb.append("\n");

        Arrays.sort(arr, comp);

        for(int i=0; i<10; i++){
            sb.append(arr[i].value+" ");
        }

        System.out.println(sb);
    }
}

class MyInteger2{
    int value;

    public MyInteger2(int value) {
        this.value = value;
    }
}