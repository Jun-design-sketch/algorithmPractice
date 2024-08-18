package basic.fastIOPractice;

import java.io.*;
//    5
//    1 1
//    12 34
//    5 500
//    40 60
//    1000 1000
public class Main {
    public static void main(String[] args) throws IOException {
        // cause of IO speed, Scanner(X) BufferReader/BufferWriter(O) or StringBuilder
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // n == how many a + " " + b?
        for(int i=0; i<n; i++){
            String str[] = br.readLine().split(" ");
            int added = Integer.parseInt(str[0])+Integer.parseInt(str[1]);
            bw.write(""+added+"\n"); // BufferedWriter.write(int) == ASCII output
        }
        bw.flush(); // ensure that the data is flushed out
        bw.close(); // do not forget CLOSE
    }
}
