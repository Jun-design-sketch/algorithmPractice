package backTracking.array15652;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 自然数nとmが与えられる。
    // 1からnまでの自然数の中m個を選ぶ数列
    // 同じ数を複数回選んでも良い
    // 数列はA1<=A2<=... であること。
    public static StringBuilder sb = new StringBuilder();
    public static int n,m;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        br.close();

        arr = new int[m];
        recursiveTTTT(0, 0);

        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void recursiveTTTT(int depth, int before) {
        if(depth == m) {
            for(int el:arr){
                sb.append(el+" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(i >= before-1){
                arr[depth] = i+1;
                recursiveTTTT(depth+1, arr[depth]);
            }
        }
    }
}
