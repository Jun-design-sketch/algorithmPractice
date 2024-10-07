package numberTheory.closeWindows13909;

import java.io.*;

public class Main {
    // 開いている窓の数を求めよ
    // 初期状態で全ての窓は閉されている
    // 1番目の人は１の倍数の窓を開ける
    // 2番目の人は２の倍数の窓を閉じる
    // ...
    // 最後に開いている窓の数は？

    // 約数の数が奇数であれば、窓は開く

    // N = 2^a * 3^b + 5*c
    // (a+1)*(b+1)*(c+1)が約数の数
    // 掛け算は一つだけでも偶数であれば結果偶数
    // 全ての素因数の数が偶数でなければ、約数の数は偶数になってしまう。
    // 全ての素因数の数が偶数ということは、√nは自然数になる
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 窓の数
        int n = Integer.parseInt(br.readLine());
        br.close();

        int count = 0;
        for(int i=1; i*i<=n; i++){
            count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}

class Solution {
    public void sol1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 窓の数
        int n = Integer.parseInt(br.readLine());
        br.close();

        int count = 0;
        for(int i=1; i<=n; i++){
            double rootD = Math.sqrt(i);
            double rootI = (int) Math.sqrt(i);
            if(rootD == rootI) count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
