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

    /**
     * Ｒ，Ｇ，Ｂに塗る時にかかる費用を２次元配列で保持する。
     * costList[0][0] = 1番目の家を赤に塗る時にかかる費用
     * costList[0][1] = 1番目の家を緑に塗る時にかかる費用
     * ...
     */
    public static int[][] costsList;
    public static int[][] dp;
    public static int ans;
    public static final int red = 0;
    public static final int green = 1;
    public static final int blue = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 家の数
        n = Integer.parseInt(br.readLine());
        // 家を塗るのに必要な費用
        costsList = new int[n][3];

        // 費用パラメータの取得
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++){
                costsList[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        // 家を塗る各ケース毎の累積合を格納する変数
        dp = new int[n][3];
        // １番目の家を塗る費用は、費用そのまま
        dp[0][red] = costsList[0][red];
        dp[0][green] = costsList[0][green];
        dp[0][blue] = costsList[0][blue];
        // ２番目〜N番目の家を塗る費用を求める
        // →累積合の最小値を求める
        int answer = Math.min(
                paintCost(n-1, red),
                Math.min(paintCost(n-1, green), paintCost(n-1, blue))
        );

        bw.write(""+answer);
        bw.flush();
        bw.close();
    }

    // 例えば３番目の家を塗る時を計算するなら
    // ２番目の家を塗る時の値がdp[1][color]に格納ずみなので
    // 以前の演算結果を流用できる。。
    public static int paintCost(int n, int color) {
        // 探索していない配列要素なら、未計算なので対象
        if(dp[n][color] == 0) {
            if(color == red){
                // 再帰的呼び出し：ピラミッドの最上階から１階ずつ下を呼び出す。
                dp[n][red] = Math.min(paintCost(n-1, green), paintCost(n-1, blue)) + costsList[n][red];
            }else if(color == green){
                dp[n][green] = Math.min(paintCost(n-1, red), paintCost(n-1,blue)) + costsList[n][green];
            }else{
                dp[n][blue] = Math.min(paintCost(n-1, red), paintCost(n-1, green)) + costsList[n][blue];
            }
        }
        return dp[n][color];
    }
}
