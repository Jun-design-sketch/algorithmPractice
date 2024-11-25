package backTracking.startLink14889;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int N;
    public static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<4; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        calculator(0, 0);

        bw.write("testing...");
        bw.flush();
        bw.close();
    }

    /*
    **
     */
    public static void calculator(int value, int depth) {
        if(depth == N/2){
            MIN = MIN > value ? value : MIN;
            return;
        }

        // TODO: ここ
        for(int i=0; i<N; i++){

        }
    }
}
