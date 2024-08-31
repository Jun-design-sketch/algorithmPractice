package bruteForce.blackJack2798;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // number of cards N(3~100), target M(10~300,000)
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // each cards: totalSize== N
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        br.close();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;
        int curSum;
        // Nestedしたくないけど。。
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                for(int k=j+1; k<N; k++){
                    curSum = arr[i]+arr[j]+arr[k];
                    if(curSum <= M){
                        answer = answer < curSum ? curSum : answer;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
