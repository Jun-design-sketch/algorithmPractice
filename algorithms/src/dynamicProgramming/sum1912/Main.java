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


        doSomething();

        bw.write("test");
        bw.flush();
        bw.close();
    }

    /*
    * 1個1個の元素から2,3,4... ~ n-1,n.. 6個元素があるとしたら
    *
    * |     0
    * |    0 0
    * |   0 0 0
    * |  0 0 0 0
    * | 0 0 0 0 0
    * |1 1 1 1 1 1 => ここは最初入力済み: arr[n][1~n];
    * --------------->
    * sums[n-1][1] = arr[n][1] + arr[n][2] ... sums[n-1][n-1] = arr[n][n-1] + arr[n][n]
    *
    * 連続する数字の合計を求める漸化式は？
    */
    public static void doSomething() {

    }
}
