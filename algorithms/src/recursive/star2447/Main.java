package recursive.star2447;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // n = 3^(k), 1<=k<=8
        br.close();
        // (n/3)*(n/3)の正方形を(n/3)のパターンに囲む。
        // nが3のパターン
        // ***
        // * *
        // ***

        int horizontal = n;
        int vertical = n;
        // int square = (int) (Math.log(n) / Math.log(3));
        calculateStar(n);

        bw.write("test");
        bw.flush();
        bw.close();
    }

    public static int calculateStar(int n) {
        if(n==1) return 1;
        return n / calculateStar(n/3);
    }
}
