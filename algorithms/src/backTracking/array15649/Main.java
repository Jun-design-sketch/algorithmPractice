package backTracking.array15649;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 自然数NとMがあるとき、1からNまでの自然数の中で
    // 重複なくM個を選んだ数列を全て求めよ

    // bruteForceとの違い？
    // bruteForceは全ての場合分けを判断する。数が多ければ多いほど資源を消耗する
    // backTrakingは？
    // nodeの有望性を判断する。
    // DFS(深さ優先探索）はツリー巡回の１つの形式であり、backTrackに使用するアルゴリズムの一つである
    // そのほかはBFS（横幅優先探索）もあるらしい。
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.close();

        arr = new int[m];
        visit = new boolean[n];
        writer(n, m, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void writer(int n, int m, int depth) {
        if(depth == m) {
            for(int val: arr) {
                sb.append(val+" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<n; i++){
            if(visit[i] == false) {
                visit[i] = true;
                arr[depth] = i+1;
                writer(n, m, depth+1);
                visit[i] = false;
            }
        }
    }
}
