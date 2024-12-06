package dynamicProgramming.fantasticFunction9184;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
// 再帰関数を考えるとワクワクが止まらない！ではないけれど
// 動的計画法によってa,b,cが与えられた時 w(a, b, c)を求めよ
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        StringBuilder sb = new StringBuilder();
        dp = new int[21][21][21];
        while((line=br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append("w(").append(a).append(", ");
            sb.append(b).append(", ");
            sb.append(c).append(") = ");
            int d = doSomething(a, b, c);
            sb.append(d).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    /*
    ** でもこれを動的計画法に変えるんだよね？
     */
    public static int doSomething(int a, int b, int c) {
        // 以前の結果をキープして効率さを得る
        if(inRange(a, b, c) && dp[a][b][c] != 0) return dp[a][b][c];
        if(a == 0 || b == 0 || c == 0) return 1;
        if(a > 20 || b > 20 || c > 20) return dp[20][20][20] = doSomething(20, 20, 20);
        if(a < b && b < c){
            return doSomething(a,b,c-1)+doSomething(a,b-1,c-1)-doSomething(a,b-1,c);
        }else{
            return  doSomething(a-1,b,c) + doSomething(a-1,b-1,c) +
                    doSomething(a-1,b,c-1) - doSomething(a-1,b-1,c-1);
        }
    }

    public static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
