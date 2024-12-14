package dynamicProgramming.rgbDistance1149;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // RGB Stには家がN個ある。距離は直線、１〜N番家まで順番にある
    // 家は赤・緑・青のうち１つの色を塗らなければならない。
    // 各々の家を塗る費用が与えられる

    // 以下規則を満たしつつ全ての家を塗る費用の最小値を求めよ
    // ①1番家の色は2番家の色と同じでないこと。
    // ②N番家の色はN-1番家の色と同じでないこと。
    // ③i(2<=i<=N-1)番家の色はi-1, i+1番家の色と同じでないこと。
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[3][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++){
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        doSomething();

        bw.write("working...");
        bw.flush();
        bw.close();
    }

    public static void doSomething() {

    }
}
