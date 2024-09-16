package numberTheory.reducedFraction1735;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLi = br.readLine().split(" ");
        String[] secondLi = br.readLine().split(" ");
        int son1 = Integer.parseInt(firstLi[0]);
        int mom1 = Integer.parseInt(firstLi[1]);
        int son2 = Integer.parseInt(secondLi[0]);
        int mom2 = Integer.parseInt(secondLi[1]);
        br.close();

        int momMul = mom1 * mom2;
        int sonSum = (son1*mom2) + (son2*mom1);
        int[] arr = new int[]{momMul, sonSum};
        Arrays.sort(arr);

        int a = arr[1];
        int b = arr[0];

        while(b != 0){
            int tmp = a;
            a = b;
            b = tmp%b;
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(sonSum/a+" "+momMul/a);
    }
}
