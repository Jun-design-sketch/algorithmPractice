package arrayOneCount;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // variable
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // input firstLine: count of number
        String str[] = br.readLine().split(" ");  // input secondLine: all numbers between " "
        int k = Integer.parseInt(br.readLine()); // input thirdLine: key number
        // calculate
        long num = Arrays.stream(str)
                .mapToInt(Integer::parseInt)
                .filter(el -> el - k == 0)
                .count();
        // output
        bw.write(""+num);
        bw.flush();
        bw.close();
    }
}
