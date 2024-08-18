package string.string11654;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char ch = (char) br.read();
        int ascii = (int)ch;
        br.close();
        bw.write(""+ascii);
        bw.flush();
        bw.close();
    }
}
