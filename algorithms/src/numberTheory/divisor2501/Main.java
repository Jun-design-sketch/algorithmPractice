package numberTheory.divisor2501;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str= br.readLine();
        br.close();
        StringTokenizer st = new StringTokenizer(str," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // Nの約数の中、K番目に少ない数を出力せよ
        // 少ない数を出力なので、少ない数から進めていけば良い。
        int count = 0;
        for(int i=1; i<=n; i++){
            if(n%i==0) count++;
            if(k==count){
                bw.write(""+i);
                break; // 2つ以上構文を書くときは{}しないといけないから。。
            }
        }
        if(k>count) bw.write("0");
        bw.flush();
        bw.close();
    }
}
