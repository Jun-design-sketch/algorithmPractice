package dynamicProgramming.fibonacci24116;

import java.io.*;

public class Main {
    public static int oldWayCount;
    public static int dynamicWayCount;
    // Dynamic Programming(DP) 動的計画法
    // 大きい問題を複数の下位問題に分け、各下位問題を解決した結果を保存し（Memoization*）
    // これを繰り返す方法で問題を解決するアルゴリズム設計手法
    // 最適化問題と関連がある

    // *Memoization
    // "Memo"から由来し、計算された値をメモリに保存し同一演算を繰り返さないようにする。
    // 再帰関数でよく使われる
    // 主に関数呼び出しと関連した計算結果を保存することに特化されている

    // Caching
    // よく使われる・アクセス時間がかかるデータをメモリに臨時保存し早く使うそれ
    // 速度向上・再利用性・有効性管理（TTL：Time to Live）
    // 大は小を束ねる。Cachingはより包括的なもの
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        oldWayCount = 0;
        dynamicWayCount = 0;
        ordinaryFibonacci(n);
        dynamicFibonacci(n);

        StringBuilder sb = new StringBuilder();
        sb.append(oldWayCount).append(" ").append(dynamicWayCount);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 普通の再帰関数
    // fib(n) {
    // 　if (n = 1 or n = 2)
    // 　then return 1;  # 코드1
    // 　else return (fib(n - 1) + fib(n - 2));
    // }
    public static int ordinaryFibonacci(int n) {
        if(n == 1 || n == 2) {
            oldWayCount++;
            return 1;  // code#1
        } else {
            return ordinaryFibonacci(n-1) + ordinaryFibonacci(n-2);
        }
    }

    // DPで解いた場合
    // アルゴリズム表現のための意思コード（pseudocode）
    // fibonacci(n) {
    // 　f[1] <- f[2] <- 1; f[1] f[2]は全て値１で初期化される。
    // 　for i <- 3 to n for(i~n)
    // 　f[i] <- f[i - 1] + f[i - 2];  f[i]はf[i-1]+f[i-2]だ。
    // 　return f[n]; f(n)を返却する。
    // }
    public static int dynamicFibonacci(int n) {
//        if(n == 1 || n == 2) {
//            return 1;
//        }
        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 1;
        for(int i=3; i<=n; i++) {
            dynamicWayCount++;
            f[i] = f[i-1]+f[i-2]; // #code2
        }
        return f[n];
    }
}
