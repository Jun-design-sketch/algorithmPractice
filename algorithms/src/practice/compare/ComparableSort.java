package practice.compare;

import java.util.Arrays;

public class ComparableSort {
    public static void main(String[] args) {
        MyInteger[] arr = new MyInteger[10];
        for(int i=0; i<10; i++){
            arr[i] = new MyInteger((int)(Math.random()*100));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            sb.append(arr[i].value+ " ");
        }
        sb.append("\n");

        Arrays.sort(arr);

        for(int i=0; i<10; i++){
            sb.append(arr[i].value+" ");
        }
        System.out.println(sb);
    }
}

class MyInteger implements Comparable<MyInteger> {
    int value;

    public MyInteger(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyInteger o) {
        return this.value - o.value;
    }
}
