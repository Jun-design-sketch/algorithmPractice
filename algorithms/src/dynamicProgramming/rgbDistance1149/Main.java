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
    public static int n;
    public static int[][] arr;
    public static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[3][n+1];

        for(int i=1; i<n+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<4; j++){
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
        // 以前と以降の家とは違う色を塗る時、費用の全量が最小限になる方法。。
        // DPに入ってからあまり捗らなず
        ans = new int[n];
        boolean[] bol = new boolean[3];

        for(int i=1; i<n+1; i++) {
            int a = arr[1][i];
            int b = arr[2][i];
            int c = arr[3][i];
//            int min = Math.min(a, Math.min(b, c));
//            if (i % 3 == 1){
//
//                if(min == a) { ans[i] = arr[1][i];
//                else if(min == b) { ans[i] = arr[2][i]; }
//                else { ans[i] = arr[3][i]; }
//            }
            // TODO: 最初R,G,Bのどれかを選択することによって以降の最初値が決まるので場合分けの漸化式
            // ans[1][0] = arr[1][0]であれば
            // ans[2][0] += min(arr[1][1], arr[1][2]),
            // ...
        }
    }
}
