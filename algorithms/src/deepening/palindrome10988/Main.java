package deepening.palindrome10988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 1;
        String[] strArr = br.readLine().split("");
        for(int i=0; i< strArr.length/2; i++){
            if(!strArr[i].equals(strArr[strArr.length-1-i])){
                answer = 0;
                break;
            }
        }
        bw.write(""+answer);
        br.close();
        bw.flush();
        bw.close();
    }
}
