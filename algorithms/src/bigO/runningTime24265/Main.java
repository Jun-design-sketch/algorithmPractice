package bigO.runningTime24265;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        MenOfPassion(A[], n) {
//            sum <- 0;
//            for i <- 1 to n - 1
//            for j <- i + 1 to n
//            sum <- sum + A[i] × A[j]; # 코드1
//            return sum;
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1<=a<=500,000
        long a = Integer.parseInt(br.readLine());
        br.close();
        // iの実行回数は？n−1
        // jの実行回数は？ n-1, n-2, ... 1, 0までの合計
        // 例：i=1, j=n-1. jに対してiを1回実行するので、jの合計を求めれば良い。iは計算式で不要
        // (n-1 + 1) * (n-1)/2
        // 実行回数
        long answer = a*(a-1)/2;
        System.out.println(answer);
        // 最高次項
        System.out.println(2);
    }
}
