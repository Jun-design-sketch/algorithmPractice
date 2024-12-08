package dynamicProgramming.tile1904;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static HashSet<Integer> set;
    public static int[] container;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        br.close();

        // BT
        // set = new HashSet<>();
        // counter(n, 0, 0);
        // int result = set.size();
        // int answer = result % 15746;
        // DP
        container = new int[1000001]; // max(n) == 1,000,000
        container[1] = 1;
        container[2] = 2;
        dynamicCounter(3, n);

        // bw.write(String.valueOf(answer));
        bw.write(String.valueOf(container[n]));
        bw.flush();
        bw.close();
    }
    // DP: memoization, divide
    // 問題をより小さい問題に分割する。小さい問題の結果を保持する。
    // 大きさNの数列を構成する方式は以下２つになる
    // ①(N-1)の数列に1をくっつける
    // ②(N-2)の数列に00をくっつける
    // したがって、N=3の場合、長さ2の数列＋1、長さ1の数列＋00の２つのケース合計になる。
    // N=4の場合も同様、（N=2の場合）+（N=3の場合）であるため、Fibonacci数列の解き方と同じ

    // ただしfor文のループで解くには
    // N=96以降から莫大な数字になるので15746で割り算した結果(mod)を求める問題仕様
    // modular演算
    // (a+b) mod c = [(a mod c) + (b mod c)] mod c; <-- FibonacciのN番目mod値 == [(N-2)mod＋(N-1)mod] modが成立
    // (a-b) mod c = [(a mod c) - (b mod c) + c] mod c;
    // (a*b) mod c = [(a mod c) * (b mod c)] mod c;
    // (a^b) mod c = [(a mod c)^b mod c];
    public static void dynamicCounter(int curr, int goal) {
        container[curr] = (container[curr-2]+container[curr-1]) % 15746;
        if(curr < goal) dynamicCounter(curr+1, goal);
    }

    // backTrackingになった気がする
    public static void counter(int empty, int curr, int next) {
        // check existence & save
        if(next == n){ // なんかすっきりしない
            if(!set.contains(curr)) set.add(curr);
            return;
        }
        // recursive creation
        // case "00"
        if(empty >= 2){
            empty -= 2;
            next += 2;
            counter(empty, curr, next);
            empty += 2;
            next -= 2;
        }
        // case "1"
        curr += Math.pow((double)2, (double)next);
        empty -= 1;
        next += 1;
        counter(empty, curr, next);
        empty += 1;
        next -= 1;
    }
}


// MEMO：いつも忘れる
// Permutation 順列 순열
// 順番を考慮して元素を羅列する場合の数
// {A,B,C}のうち２つを選ぶ AB, BA, AC, CA, BC, CB
// P(n, r) = n! / (n-r)!
// n*(n-1)*...(n-r+1)!なので
// Combination 組み合わせ 조합
// 順番を考慮せず元素を選択する場合の数
// {A,B,C}のうち２つを選ぶ AB, AC, BC
// C(n, r) = n! / r!(n-r)!
// rはr!個の順番を持てるので、P(n,r)からr!を分ける
// n! / (n-r)! * r!