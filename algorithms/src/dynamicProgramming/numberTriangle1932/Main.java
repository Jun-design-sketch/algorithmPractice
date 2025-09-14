package dynamicProgramming.numberTriangle1932;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int triangleSize;
    public static int[][] triangle;
    public static int[][] cumulativeSum;

//    5
//            7
//           3 8
//          8 1 0
//         2 7 4 4
//        4 5 2 6 5
// arr[x][y]で考えるとしたら
// arr[0][0] = 7
// arr[0][1] = 3, arr[1][1] = 8,
// arr[0][2] = 8, arr[1][2] = 1, arr[2][2] = 0
// arr[0][3] = 2, arr[1][3] = 7, arr[2][3] = 4, arr[3][3] = 4
// 下から上に向かう（自分の前段階の累積合）時
// 例えばarr[0][1]からは、arr[0][0]しか選べない（1個しかない）
// 例えばarr[0][2]からは、arr[0][1]しか選べない。。 arr[1][2]なら、arr[0][1], arr[1][1]のうちどれか。
// つまり自分自身が角部屋であれば、その角側の上しか選べない

// 角部屋でなければ。。
// 例えばarr[2][3]からはarr[1][2], arr[2][2]のどちらかを選べる。
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 与えられる三角形の辺
        triangleSize = Integer.parseInt(br.readLine());
        // 三角形格納配列
        triangle = new int[triangleSize][triangleSize];
        Arrays.fill(triangle, -1);
        // 累積合配列
        cumulativeSum = new int[triangleSize][triangleSize];
        Arrays.fill(cumulativeSum, -1);

        StringTokenizer st;
        // 与えられる三角形を取得
        for(int i=0; i<triangleSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while(st.hasMoreTokens()) {
                int token = Integer.parseInt(st.nextToken());
                triangle[j][i] = token;
                j++;
            }
        }
        br.close();

        // 累積合の最上階値 === 三角形の最上階値
        cumulativeSum[0][0] = triangle[0][0];
        int maximumValue = decentCost(0,0);

        bw.write("eh-");
        bw.flush();
        bw.close();
    }

    public static int decentCost(int n, int m) {
        // 各階の値をtriangle[floor][room]で考える
        // 漸化式：triangle[floor][room]から、最大の値を取得しつつ１階下に行く時
        // Math.max(triangle[floor+1][左下の部屋番号], triangle[floor+1][右下の部屋番号])
        // TODO: ここ違う。真下のもの選べないので。
        int leftDown = m;
        int rightDown = m+1;

        // TODO: これだと値の保持ができません。値の保持をどういった形式で取るか考えて
        if(n < triangleSize) {
            return Math.max(decentCost(n+1, leftDown), decentCost(n+1, rightDown));
        } else {
            return 0;
        }
    }
}
