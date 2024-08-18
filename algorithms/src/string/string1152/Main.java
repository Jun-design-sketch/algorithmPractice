package string.string1152;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strArr = br.readLine().split(" ");
        int count = strArr.length;
        if_(count > 0){
            if_(strArr[0] == ""){
                count -= 1;
            }
            if_(strArr[strArr.length-1] == ""){
                count -= 1;
            }
        }
        bw.write(""+count);
        br.close();
        bw.flush();
        bw.close();
    }
}
