package numberTheory.primeNumber17103;

import java.io.*;

public class Main {
    // Goldbach's Conjecture ゴールドバッハの予想
    // 2より大きい偶数は２つの素数の合計で表せる。
    // 偶数nが与えられたとき、ゴールドバッハパーティションの数を求めよ。
    // 素数の順番のみが違うものは同じパーティションとする。
    public static void main(String[] args) throws IOException {

    }
}

class Solution {
    public void sol1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int target = Integer.parseInt(br.readLine());
            int limit = target / 2;
            int count = 0;
            for(int j=2; j<=limit; j++) {
                if(isPrime(j) && isPrime(target-j)) count++;
            }
            sb.append(count+"\n");
        }
        br.close();

        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean isPrime(int target) {
        int limit = (int) Math.sqrt(target);
        for(int i=2; i<=limit; i++){
            if(target % i == 0) return false;
        }
        return true;
    }
}
