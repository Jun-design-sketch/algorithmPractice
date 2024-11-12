package backTracking.array15650;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] bArr;
    public static void main(String[] args) throws IOException {
        // 自然数nとmが与えられた時、以下条件を満たす長さがmである数列を全て求めよ
        // - 1~Nまでの自然数の中で重複なくM個を選んだ数列
        // - 数列は昇順であること
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.close();

        arr = new int[m];
        bArr = new boolean[n];
        writer(n, m, 0, 0);

        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void writer(int n, int m, int depth, int before) {
        // 欲しい深さまで掘ったのなら、書き込んで返す
        if(depth == m){
            for(int el: arr){
                sb.append(el+ " ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }
        // 欲しい深さまで進めさせる
        for(int i=before; i<n; i++) {
            if(bArr[i] == false) { // [i]はまだ使っていないか？
                bArr[i] = true; // [i]は使用済みであるとマーク
                arr[depth] = i+1; // 深さを１進める

                // 例えば [i] == 0の時、writer()を呼び出すと 0は使用済みの状態でwriter()に戻る
                // [i] == 1の状態で入り、次に2が使用済みとなりreturn;
                // ここのfor文で(1,2) (1,3) (1,4)が繰り返される。全てreturn句でsb.append()済みとなる
                // 次に [i] == 1の時も、同様に1以外を持って残りを繰り返す。。

                writer(n, m, depth+1, i); // 進んだ深さで再帰呼び出し。
                bArr[i] = false; // 最後まで掘って帰ってきたら、[i]を未使用状態に戻す
            }
        }
    }
}
