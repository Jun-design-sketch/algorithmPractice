package sorting.numSort10814;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.sol1();
    }
}

class Solution {
    protected void sol2() {
        // 今度はString整形を減らす方向で考えよう。。

    }
    protected void sol1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = i + " " + br.readLine();
        }
        // なんか途中からこれは違う気がしてきたけど一旦完成はして正解ではあった
        // 予想通りメモリ310MBくらい使ってしまってアホの実装
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringTokenizer st1 = new StringTokenizer(o1, " ");
                StringTokenizer st2 = new StringTokenizer(o2, " ");
                int signUpNum1 = Integer.parseInt(st1.nextToken());
                int signUpNum2 = Integer.parseInt(st2.nextToken());
                int old1 = Integer.parseInt(st1.nextToken());
                int old2 = Integer.parseInt(st2.nextToken());
                if(old1 != old2){
                    return old1-old2;
                }else{
                    return signUpNum1-signUpNum2;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<n; j++){
            sb.append(arr[j]
                    .substring(
                            arr[j].indexOf(" ")+1,
                            arr[j].length()
                    )+"\n");
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
