package dynamicProgramming.fantasticFunction9184;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
// 再帰関数を考えるとワクワクが止まらない！ではないけれど
// 以下のような再帰関数 w(a, b, c)があるとする
// if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns: 1
// if a > 20 or b > 20 or c > 20, then w(a, b, c) returns: w(20, 20, 20)
// if a < b and b < c, then w(a, b, c) returns: w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
// otherwise it returns: w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
// 作るのは簡単だけど実行時間が非常に長くなる。a,b,cが与えられた時 w(a, b, c)を求めよ
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while((line=br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, " ");
            doSomething(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
    }

    public static void doSomething(int a, int b, int c) {

    }
}
