package sorting.numSort10989;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        int maxIndex = 0;
        // 最大値を求める
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        br.close();
        // カウントする
        int[] count = new int[max+1];
        for(int i=0; i<n; i++){
            count[arr[i]] += 1;
        }
        // カウントを累計合にする
        for(int j=0; j<max; j++){
            count[j+1] += count[j];
        }
        // arrの各値を巡回し、countの通り配置していく
        int[] answer = new int[n];
        for(int k=arr.length-1; k>-1; k--){
            answer[count[arr[k]]-1] = arr[k];
            count[arr[k]] -= 1;
        }
        // 出力
        StringBuilder sb = new StringBuilder();
        for(int m=0; m<arr.length; m++){
            sb.append(answer[m]+"\n");
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
