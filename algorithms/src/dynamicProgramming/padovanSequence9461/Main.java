package dynamicProgramming.padovanSequence9461;

import java.io.*;

public class Main {
    // 辺の長さが１の正三角形から始め螺旋型に積み重ねる
    // 螺旋で最も長い辺の長さをkとする。その辺に長さkの正三角形を追加する。
    // nが与えられた時、P(n)を求めよ
    public static int answer;
    public static long[] container;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int[] cases = new int[n];
        for(int i=0; i<n; i++) {
            cases[i] = Integer.parseInt(br.readLine());
            max = max < cases[i] ? cases[i] : max;
        }
        br.close();

        container = new long[max+1];
        container[1] = 1;
        container[2] = 1;
        container[3] = 1;
        padovan(4, max);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(container[cases[i]]).append("\n");
        }

        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    /*
    * パドバン数列: P(n) = P(n-2) + P(n-3)
    * 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12
    * 2 = 1+1, 3 = 2+1, 4 = 2+2, 5 = 3+2, 7 = 3+4
    * 9 = 4+5 == P(n-3) + P(n-2)
    * 12 = 5+7 == P(n-3) + P(n-2)
     */
    public static void padovan(int curr, int goal) {
        container[curr] = container[curr-2] + container[curr-3];
        if(curr == goal) return;
        curr++;
        padovan(curr, goal);
    }
}
