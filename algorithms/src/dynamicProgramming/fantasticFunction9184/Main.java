package dynamicProgramming.fantasticFunction9184;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
// 再帰関数を考えるとワクワクが止まらない！ではないけれど
// 動的計画法によってa,b,cが与えられた時 w(a, b, c)を求めよ
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        StringBuilder sb = new StringBuilder();
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
        if(a == 0 || b == 0 || c == 0) return 1;
        if(a > 20 || b > 20 || c > 20) return doSomething(20, 20, 20);
        if(a < b && b < c){
            return doSomething(a,b,c-1)+doSomething(a,b-1,c-1)-doSomething(a,b-1,c);
        }else{
            return  doSomething(a-1,b,c) + doSomething(a-1,b-1,c) +
                    doSomething(a-1,b,c-1) - doSomething(a-1,b-1,c-1);
        }
    }
    // 何かが0になれば1を返す
    // 何かが20超過なら全部20にして再度返す
    // a<b<cなら(a,b,c-1)+(a,b-1,c-1)-(a,b-1,c)
    // a<b<cでなければ？(a-1,b,c-1)+(a-1,b-1,c)+(a-1,b,c-1)-(a-1,b-1,c-1)
    // そもそも動的計画法とは、以前の結果をキープして効率さを得るもの...
}
