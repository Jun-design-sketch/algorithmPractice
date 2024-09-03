package sorting.cutLine25305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLi = br.readLine().split(" ");
        // 総員n名、受賞者k名
        int n = Integer.parseInt(firstLi[0]);
        int k = Integer.parseInt(firstLi[1]);
        // 皆の点数
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // k番目の人の点数を出力する
        System.out.println(arr[n-k]);
    }
}
