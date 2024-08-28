package bigO.runningTime24266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        MenOfPassion(A[], n) {
//            sum <- 0;
//            for i <- 1 to n
//            for j <- 1 to n
//            for k <- 1 to n
//            sum <- sum + A[i] × A[j] × A[k]; # 코드1
//            return sum;
//        }
        // n^3
        BigInteger n = BigInteger.valueOf(Integer.parseInt(br.readLine()));
        BigInteger square = n.multiply(n);
        BigInteger cube = square.multiply(n);
        br.close();
        // 15~17桁の正確性を保証するので足りない
//        long answer = (long) Math.pow(n,3);
        // 実行回数と指数
        System.out.println(cube);
        System.out.println(3);
    }
}
