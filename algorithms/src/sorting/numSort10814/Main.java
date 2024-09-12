package sorting.numSort10814;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    // 3
    // 21 Junkyu
    // 21 Dohyun
    // 20 Sunyoung
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        // solution.sol1();
        solution.sol2();
    }
}

class Solution {
    // 2次元配列を用いる：58mbほどでだいぶマシになった
    protected void sol2() throws IOException {
        // 今度はString整形を減らす方向で考えよう。。
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // [0]に順番を入れる。[1]に年齢を入れる。[2]に氏名を入れる。
        String[][] arr = new String[n][3];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = String.valueOf(i); // intをまたStringにしているのがどうもスッキリしない
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int o1Old = Integer.parseInt(o1[1]);
                int o2Old = Integer.parseInt(o2[1]);
                if(o1Old != o2Old){
                    // 年齢が同じでなければ、年齢でソートする
                    return o1Old - o2Old;
                }else{
                    // 年齢が同じであれば、加入順でソートする
                    int o1Num = Integer.parseInt(o1[0]);
                    int o2Num = Integer.parseInt(o2[0]);
                    return o1Num - o2Num;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int j=0; j<n; j++){
            sb.append(arr[j][1]+" "+arr[j][2]+"\n");
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
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
