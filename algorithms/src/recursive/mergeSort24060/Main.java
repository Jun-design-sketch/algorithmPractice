package recursive.mergeSort24060;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int n = Integer.parseInt(st.nextToken()); // 配列のサイズ
        int k = Integer.parseInt(st.nextToken()); // 保存回数の指定


        bw.write("test");
        bw.flush();
        bw.close();
    }
}
