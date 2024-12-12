package dynamicProgramming.sum1912;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 任意の数列が与えられた時、連続したいくつかの数字の合計が最大になる場合の値を求めよ
    // 数字は１つ以上選択せねばならない。
    public static int[] arr;
    public static Integer[] dp;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        dp[0] = arr[0];
        max = arr[0];
        recur(n-1);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

// Top-down
    static int recur(int n) {
        if(dp[n] == null) {
            dp[n] = Math.max(recur(n - 1) + arr[n], arr[n]);
            max = Math.max(dp[n], max);
        }
        return dp[n];
    }

// Down-top
//    1からN-1まで繰り返す
//    for (int i = 1; i < N; i++) {
//        dp[i]は, dp[i-1]+arr[i]とarr[i]のうち大きいもの
//        dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
//    }

}
