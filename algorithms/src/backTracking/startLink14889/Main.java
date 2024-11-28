package backTracking.startLink14889;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static boolean[] visit;
    public static int N;
    public static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        combi(0, 0);

        System.out.println(MIN);
    }

    public static void combi(int index, int depth) {
        if(depth == N/2){
            diff();
            return;
        }

        for(int i=index; i<N; i++){
            if(!visit[i]) {
                visit[i] = true;
                combi(i+1, depth+1);
                visit[i] = false;
            }
        }
    }

    public static void diff() {
        int teamA = 0;
        int teamB = 0;

        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(visit[i] == true && visit[j] == true) {
                    teamA += arr[i][j];
                    teamA += arr[j][i];
                } else if(visit[i] == false && visit[j] == false) {
                    teamB += arr[i][j];
                    teamB += arr[j][i];
                }
            }
        }
        int value = Math.abs(teamA - teamB);
        if(value == 0) {
            System.out.println(value);
            System.exit(0);
        }
        MIN = Math.min(value, MIN);
    }
}
