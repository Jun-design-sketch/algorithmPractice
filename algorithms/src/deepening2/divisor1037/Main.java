package deepening2.divisor1037;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    // 1とN以外の約数が全て与えられた時、Nを求めよ
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfDivisor = Integer.parseInt(br.readLine());
        TreeSet<Integer> allDivisor = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for(int i=0; i<numberOfDivisor; i++){
            allDivisor.add(Integer.valueOf(st.nextToken()));
        }

        int min = allDivisor.pollFirst();
        int max = allDivisor.isEmpty() ? min : allDivisor.pollLast();

        bw.write(String.valueOf(min*max));
        bw.flush();
        bw.close();
    }
}
