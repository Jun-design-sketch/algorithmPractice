package backTracking.array15651;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 1~Nまでの自然数のうち、M個を選んだ数列を全て出力せよ
    // 同じ数を複数回選んでも良い。
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        br.close();
        arr = new int[m];

        // recursiveT_T(n, m, 0);
        newRecursiveBackTracking(0);

        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void recursiveT_T(int n, int m, int depth) {
        if(depth == m) {
            for(int el: arr){
                sb.append(el+" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            // if(bArr[i] == false){ // [i]は使っていないか？
                // bArr[i] = true; // [i]はもう使ったとする判定を消す。
                arr[depth] = i+1;
                recursiveT_T(n, m, depth+1);
                // bArr[i] = false;
            // }
        }
    }

    public static void newRecursiveBackTracking(int depth) {
        if(depth == m) {
            for(int el: arr){
                sb.append(el+" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            arr[depth] = i+1;
            newRecursiveBackTracking(depth+1);
        }
    }
}
