package string.string5622;

import java.io.*;

public class Main {
    public static int ASCII_A = 65;
    public static int ASCII_Z = 90;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] telNumber = br.readLine().toCharArray();



        br.close();
        bw.flush();
        bw.close();
    }
}
