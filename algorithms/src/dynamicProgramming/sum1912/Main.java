package dynamicProgramming.sum1912;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 任意の数列が与えられた時、連続したいくつかの数字の合計が最大になる場合の値を求めよ
    // 数字は１つ以上洗濯せねばならない。
    public static int[][] sums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        sums = new int[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++) {
            sums[n][i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        bw.write("test");
        bw.flush();
        bw.close();
    }

// Top-down
//    static int recur(int N) {
//        if(dp[N] == null) {
//            dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
//            max = Math.max(dp[N], max);
//        }
//        return dp[N];
//    }
// Down-top
//    for (int i = 1; i < N; i++) {
//        dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
//    }
}
