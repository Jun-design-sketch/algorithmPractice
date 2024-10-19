package recursive.star2447;

import java.io.*;
// 再帰関数は問題の分割というよりかは、繰り返していく作業の共通性と規則性を掴むことが鍵になりそう

public class Main {
    // 与えられる領域を９つに分け、真ん中は空にする。
    public static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // n = 3^(k), 1<=k<=8
        br.close();
        arr = new boolean[n][n];
        // int square = (int) (Math.log(n) / Math.log(3));
        // 0, 1, 2, [3, 4, 5], 6, 7, 8
        calculateStar(0, 0, n, false);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == true) sb.append(" ");
                else sb.append("*");
                if(j==n-1) sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void calculateStar(int x, int y, int n, boolean blank) {
        if(blank){
            for(int i=x; i<x+n; i++){
                for(int j=y; j<y+n; j++){
                    arr[i][j] = true;
                }
            }
            return;
        }

        if(n==1) return;

        // N=3^3 => 1ブロックのサイズは9(3^2)
        // N=3^2 => 1ブロックのサイズは3(3^1)
        int size = n/3;
        int count = 0;
        // 区域は９つに別れる。iの上限がnかつ毎回+=sizeされるため3回＊3回実行となる
        for(int i=x; i<x+n; i+=size) {
            for(int j=y; j<y+n; j+=size) {
                count++;
                // *** を考えた時、１つのブロック中でブランクは５番目
                // * *
                // ***
                if(count == 5) calculateStar(i, j, size, true);
                else calculateStar(i, j, size, false);
            }
        }
    }
}
