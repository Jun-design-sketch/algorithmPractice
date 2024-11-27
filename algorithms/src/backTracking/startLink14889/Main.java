package backTracking.startLink14889;

import java.io.*;
import java.util.HashSet;
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

        HashSet<Integer> currentMembers = new HashSet<>();
        calculator(0, 0, currentMembers);

        bw.write(String.valueOf(MIN));
        bw.flush();
        bw.close();
    }

    // まず、本人(1)以外の誰か(2)がチームになった場合
    // arr[1][2]+arr[2][1]がチームステータスに足される
    // ここでもう１名(3)足されると。。arr[1][3] arr[3][1] arr[2][3]が足される。。
    public static void calculator(int value, int depth, HashSet<Integer> currentMembers) {
        if(depth == N/2){
            int teamA = value;

            // TODO: ここの集計が間違っている。
            int teamB = otherTeamScore(currentMembers);

            int result = Math.abs(teamA-teamB);
            MIN = MIN > result ? result : MIN;
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                if(arr[i][j] != 0 && arr[j][i] != 0){
                    // TODO: こうすると既に２名が加入し、追加で１名入る場合の計算ができない。
                    int tmp1 = arr[i][j];
                    int tmp2 = arr[j][i];
                    arr[i][j] = 0;
                    arr[j][i] = 0;
                    currentMembers.add(i);
                    currentMembers.add(j);

                    calculator(value+tmp1+tmp2, depth+1, currentMembers);

                    currentMembers.remove(i);
                    currentMembers.remove(j);
                    arr[i][j] = tmp1;
                    arr[j][i] = tmp2;
                }
            }
        }
    }

    public static int otherTeamScore(HashSet<Integer> currentMembers) {
        // 残りのメンバーを抽出する
        int[] restOfThem = new int[N/2];
        int count = 0;
        for(int i=0; i<N; i++){
            if(!currentMembers.contains(i)){
                restOfThem[count] = i;
                count++;
            }
        }
        // 残りのメンバーで可能な組み合わせのスコアの合計をリターンする

    }
}
