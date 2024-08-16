package string11720;

import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // how many numbers will come?
        int n = Integer.parseInt(br.readLine());
        // get numbers, close br
        String[] arr = br.readLine().split("");
        br.close();
        // stream practice
        OptionalInt sum = Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .reduce(Integer::sum);
        int answer = sum.getAsInt();
        bw.write(""+answer);
        bw.flush();
        bw.close();
    }
}
