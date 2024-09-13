package sorting.numSort18870;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    // 5
    // 2 4 -10 4 -9
    public static void main(String[] args) throws IOException {
        // 座標圧縮：値の大小関係のみを求めるのであればどうする？
        // これは、問題の単純化などに用いられる基礎概念
        // 最短ルートを求めるのに座標の数が多すぎる時、座標を単純化した後に演算するなどができる。
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // original array
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // referenceだからprimitiveみたいに複製しようとしたら、同じアドレスを指してしまう
        int[] originalArr = Arrays.copyOf(arr, arr.length);

        Arrays.sort(arr);

        // sorted array => input hashMap with ranking
        Map<Integer, Integer> hashMap = new HashMap<>();
        int index = 0;
        for(int j=0; j<n; j++){
            if(!hashMap.containsKey(arr[j])){
                hashMap.put(arr[j], index);
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int k=0; k<n; k++){
            sb.append(hashMap.get(originalArr[k])+" ");
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
