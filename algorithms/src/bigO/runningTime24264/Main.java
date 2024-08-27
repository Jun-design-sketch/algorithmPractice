package bigO.runningTime24264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        MenOfPassion(A[], n) {
//            sum <- 0;
//            for i <- 1 to n
//            for j <- 1 to n
//            sum <- sum + A[i] × A[j]; # 코드1
//            return sum;
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n<=500,000だから
        long a = (long) Math.pow(Integer.parseInt(br.readLine()),2);
        br.close();
        // コードの実行回数
        System.out.println(a);
        // 最高次項
        System.out.println(2);
    }
}
