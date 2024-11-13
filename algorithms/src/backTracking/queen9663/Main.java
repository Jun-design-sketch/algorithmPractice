package backTracking.queen9663;

import java.io.*;

public class Main {
    // 大きさがN＊Nであるチェス板上に、クイーンN個を「お互い攻撃できないよう」配置するとする。
    // クイーンを配置する場合の数を求めよ
    public static int count = 0;
    public static boolean[][] chessWorld;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        // この問題がbackTrackである理由は、１つの置くと
        // その次におく駒の位置が制限されるから（bruteForceなら全量代入するが）

        // クイーンは、横・縦・斜線で移動できる。。
        // ①(1,1)におかれると (1, x)は置けない
        // ②(1,1)におかれると (x, 1)は置けない
        // ③(1,1)におかれると (1*x, 1*x)は置けない

        chessWorld = new boolean[n][n];
        countQueenWorld(n);

        bw.write("...");
        bw.flush();
        bw.close();
    }

    public static void countQueenWorld(int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                if(chessWorld[i][j]==false){
                    for(int k=0; k<n; k++){
                        chessWorld[i][k] = true;
                        chessWorld[k][j] = true;
                    }

                    chessWorld[i][j]=true;
                    countQueenWorld(n);
                }
            }
        }
    }
}
