package bruteForce.blackJack2798;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // number of cards N(3~100)
        int N = Integer.parseInt(st.nextToken());
        // target M(10~300,000)
        // intで良さそう
        int M = Integer.parseInt(st.nextToken());
        // each cards: totalSize== N
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N-1];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

    }
}
