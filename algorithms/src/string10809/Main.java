package string10809;

import java.io.*;

public class Main {
    public static int ASCII_SMALL_A = 97;
    public static int ASCII_SMALL_Z = 122;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        br.close();
        // ASCII a = 97, z = 122
        for(int i=ASCII_SMALL_A; i<=ASCII_SMALL_Z; i++){
            char ch = (char)i;
            bw.write(""+str.indexOf(ch));
            if(i != ASCII_SMALL_Z){
                bw.write(" ");
            }
        }
        bw.flush();
        bw.close();
    }
}
