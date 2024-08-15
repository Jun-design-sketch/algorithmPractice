package string2743;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // input: alphabet word
        String str = br.readLine();
        br.close();
        // return output: length
        bw.write(""+str.length());
        bw.flush();
        bw.close();
    }
}
