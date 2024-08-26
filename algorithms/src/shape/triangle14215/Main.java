package shape.triangle14215;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // a,b,c(>0)を持って、a+b+cが最大になるケースを求めよ。
        // a,b,cの値は増やすことはできないが、自由に減らせるものとする。
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        br.close();
        // 結局は減らさなければ減らさないほどお得
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        // 三角形の必須条件を満たさなければ
        if(arr[0]+arr[1]<=arr[2]){
            arr[2] = arr[0]+arr[1]-1;
        }
        int answer = arr[0]+arr[1]+arr[2];
        bw.write(""+answer);
        bw.flush();
        bw.close();
    }
}
