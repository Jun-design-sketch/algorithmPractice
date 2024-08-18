package string.string27866;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // get word, int n
        String[] word = br.readLine().split("");
        int n = Integer.parseInt(br.readLine());
        // return n th String
        bw.write(word[n-1]);
        bw.flush();
        bw.close();
    }
}
