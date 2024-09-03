package sorting.middleAverage2587;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(arr);
        int average = (arr[0]+arr[1]+arr[2]+arr[3]+arr[4]) / 5;
        int middleNum = arr[2];
        System.out.println(average);
        System.out.println(middleNum);
    }
}
