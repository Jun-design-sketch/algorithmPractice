package sorting.numSort11651;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 行数
        int n = Integer.parseInt(br.readLine());
        // 行数分の配列：行はn、列は2個
        int[][] arr = new int[n][2];
        // 配列格納
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }
        // ソート
        Arrays.sort(arr, new Comparator<int[]>() {
            // compareは最初の引数が２番目の引数より小さい場合は-を、等しい場合は0を、大きい場合は+を返す
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(arr[i][0]+" "+arr[i][1]+"\n");
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
