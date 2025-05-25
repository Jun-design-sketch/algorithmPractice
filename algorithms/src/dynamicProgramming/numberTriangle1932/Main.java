package dynamicProgramming.numberTriangle1932;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[][] triangle;
    public static int[][] cumulativeSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 与えられる三角形
        int n = Integer.parseInt(br.readLine());
        // 三角形格納配列の初期化, 初期値は-1
        triangle = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(triangle[i], -1);
        }
        // 累積合配列の初期化、初期値は-1
        cumulativeSum = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(cumulativeSum[i], -1);
        }

        // 与えられる三角形を取得
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while(st.hasMoreTokens()) {
                int token = Integer.parseInt(st.nextToken());
                triangle[i][j] = token;
                j++;
            }
        }
        br.close();

        // 累積合の最初（最上階）はそのまま
        cumulativeSum[0][0] = triangle[0][0];

        bw.write("eh-");
        bw.flush();
        bw.close();
    }

    public static int decentCost(int n) {
        // 各階の値をtriangle[floor][room]で考える
        // 漸化式：triangle[floor][room]から、最大の値を取得しつつ１階下に行く時
        // Math.max(triangle[floor-1][左下の部屋番号], triangle[floor-1][右下の部屋番号])

        // 左下・右下は端っこでedgeCaseがある
        return 0;
    }
}
