package backTracking.queen9663;

import java.io.*;

public class Main {
    // 大きさがN＊Nであるチェス板上に、クイーンN個を「お互い攻撃できないよう」配置するとする。
    // クイーンを配置する場合の数を求めよ
    public static int count = 0;

    // chessWorld[0]は１番目列を意味し、chessWorld[0]の値が行数を意味するとする
    public static int[] chessWorld;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        br.close();

        // この問題がbackTrackである理由は、１つの置くと
        // その次におく駒の位置が制限されるから（bruteForceなら全量代入するが）

        // クイーンは、横・縦・斜線で移動できる。。
        // ①(1,1)におかれると (1, x)は置けない
        // ②(1,1)におかれると (x, 1)は置けない
        // ③(1,1)におかれると (1*x, 1*x)は置けない

        chessWorld = new int[n];
        countQueenWorld(0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    /*
    ** depth == nになるまで再起呼び出しを行う。
    ** 再起呼び出しする途中で「もうクイーンを置けない」のであれば呼び出さない
     */
    public static void countQueenWorld(int depth) {
        // 最後の列まで置けたら、countを増やす
        if(depth == n) {
            count++;
            return;
        }

        // depth列の0~(n-1)行に置く場合を数える
        for(int i=0; i<n; i++){
            chessWorld[depth] = i;
            if(Possibility(depth)) {
                // 列を１ずつ進ませながら置けるかの確認を行う
                countQueenWorld(depth+1);
            }
        }
    }

    /*
    ** 「クイーンをまだ置けるか」の判定を行う。
     */
    public static boolean Possibility(int col) {
        for(int i=0; i<col; i++) {
            // 値が同じである場合：同じ行に存在する場合
            if(chessWorld[col] == chessWorld[i]) {
                return false;
            // x座標の間隔==y座標の間隔である場合：斜め45度に存在する
            } else if (Math.abs(col - i) == Math.abs(chessWorld[col] - chessWorld[i])) {
                return false;
            }
        }
        return true;
    }
}
