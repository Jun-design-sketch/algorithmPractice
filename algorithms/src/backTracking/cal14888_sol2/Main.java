package backTracking.cal14888_sol2;

import java.io.*;
import java.util.StringTokenizer;

// bestPractice
public class Main {
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int[] operator = new int[4];
    public static int[] number;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st_ = new StringTokenizer(br.readLine(), " ");
        for(int j=0; j<4; j++){
            operator[j] = Integer.parseInt(st_.nextToken());
        }
        br.close();

        dfs(number[0], 1);

        StringBuilder sb = new StringBuilder();
        sb.append(MAX).append("\n");
        sb.append(MIN);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 不要な変数の使用を減らす
    public static void dfs(int num, int index) {
        if(index == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for(int i=0; i<4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                // switchで簡潔に
                switch(i) {
                    // numはforループ内で値が保持されるので、冗長にnum値初期化が不要
                    case 0: dfs(num + number[index], index+1); break;
                    case 1: dfs(num - number[index], index+1); break;
                    case 2: dfs(num * number[index], index+1); break;
                    case 3: dfs(num / number[index], index+1); break;
                }
                operator[i]++;
            }
        }
    }
}
