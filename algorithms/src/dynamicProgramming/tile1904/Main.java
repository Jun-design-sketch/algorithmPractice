package dynamicProgramming.tile1904;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static HashSet<Integer> set;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        br.close();

        // container
        set = new HashSet<>();

        counter(n, 0, 0);
        int result = set.size();
        int answer = result % 15746;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    // 順列の場合数え（100(2) 001(2)は違う）
    // 変数：残りの桁数、現在の２進数、次の桁数
    // 定数：候補(1, 00)
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