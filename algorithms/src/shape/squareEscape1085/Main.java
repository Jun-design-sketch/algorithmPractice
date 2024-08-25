package shape.squareEscape1085;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 与えられた長方形の中で、長方形の境界に辿り着く最短距離
        // ピタゴラスの定理を思い出したが、長方形の境界までの最短距離は常に水平・垂直のどちらかのはず
        // あり得る４ケースをソートすればOK
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] arr = new int[4];
        arr[0] = x;
        arr[1] = y;
        arr[2] = w-x;
        arr[3] = h-y;
        Arrays.sort(arr);
        bw.write(""+arr[0]);
        bw.flush();
        bw.close();
    }
}
