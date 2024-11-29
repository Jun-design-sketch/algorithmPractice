package dynamicProgramming.fibonacci;

public class Main {
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
    public static void main(String[] args) {
        // 普通の再帰関数
        // fib(n) {
        // 　if (n = 1 or n = 2)
        // 　then return 1;  # 코드1
        // 　else return (fib(n - 1) + fib(n - 2));
        // }
        // DPで解いた場合
        // fibonacci(n) {
        // 　f[1] <- f[2] <- 1;
        // 　for i <- 3 to n
        // 　f[i] <- f[i - 1] + f[i - 2];  # 코드2
        // 　return f[n];
        // }

    }
}
