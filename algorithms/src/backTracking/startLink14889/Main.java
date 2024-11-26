package backTracking.startLink14889;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int N;
    public static int MIN = Integer.MAX_VALUE;
    public static int totalStatus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        totalStatus = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                totalStatus += arr[i][j];
            }
        }
        br.close();

        calculator(0, 0);

        bw.write(String.valueOf(MIN));
        bw.flush();
        bw.close();
    }

    // まず、本人(1)以外の誰か(2)がチームになった場合
    // arr[1][2]+arr[2][1]がチームステータスに足される
    // ここでもう１名(3)足されると。。arr[1][3] arr[3][1] arr[2][3]が足される。。
    public static void calculator(int value, int depth) {
        if(depth == N/2){
            int teamA = value;
            int teamB = totalStatus - value;
            int result = Math.abs(teamA-teamB);
            MIN = MIN > result ? result : MIN;
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                if(arr[i][j] != 0 && arr[j][i] != 0){
                    int tmp1 = arr[i][j];
                    int tmp2 = arr[j][i];
                    arr[i][j] = 0;
                    arr[j][i] = 0;
                    calculator(value+tmp1+tmp2, depth+1);
                    arr[i][j] = tmp1;
                    arr[j][i] = tmp2;
                }
            }
        }
    }
}
