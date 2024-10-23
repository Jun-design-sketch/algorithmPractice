package recursive.towerOfHanoi11729;

import java.io.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // ハノイの塔
        // 塔を積み立てる時の規則性
        // 一番大きいもの１つを右端に置き、残りは真ん中におく。
        // これを全量移動するまで繰り返す。
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();
        sb.append((int)(Math.pow(2,n)-1)+"\n");

        Hanoi(n, 1, 2, 3);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void Hanoi(int n, int start, int mid, int to) {
        if(n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }
        // A -> Cに運ぶ
        // n-1個をAからBへ移動
        Hanoi(n-1, start, to, mid);
        // 1個をAからCへ移動
        sb.append(start + " " + to + "\n");
        // n-1個をBからCへ移動
        Hanoi(n-1, mid, start, to);
    }
}
