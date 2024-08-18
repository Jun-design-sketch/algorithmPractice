package array.array3052;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static int ALL_LINE_NUMBERS = 10;
    public static int DIVIDED_NUMBER = 42;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // get input
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<ALL_LINE_NUMBERS; i++){
            // condition: 0 < intElement <= 1000
            hs.add(Integer.parseInt(br.readLine())%DIVIDED_NUMBER);
        }
        bw.write(""+hs.size());
        bw.flush();
        bw.close();
        }
}
