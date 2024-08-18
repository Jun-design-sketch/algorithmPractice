package string.string9086;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // firstLine has case of test
        int n = Integer.parseInt(br.readLine());
        // second~lastLine have each word
        for(int i=0; i<n; i++){
            String[] strArr = br.readLine().split("");
            bw.write(strArr[0]+strArr[strArr.length-1]+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
