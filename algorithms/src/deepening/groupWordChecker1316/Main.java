package deepening.groupWordChecker1316;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int wordCount = Integer.parseInt(br.readLine());
        int answer = wordCount;
        for(int i=0; i<wordCount; i++){
            byte[] eachWord = br.readLine().getBytes();
            boolean[] alphabet = new boolean[26];
            int before = 0;
            for(byte b : eachWord){
                byte cur = b;
                // first
                if(before != cur && alphabet[cur-97] == false){
                    before = cur;
                    alphabet[cur-97] = true;
                // not first, not repetition
                }else if(before != cur && alphabet[cur-97] == true){
                    before = cur;
                    answer--;
                    break;
                }
            }
        }
        br.close();
        bw.write(""+answer);
        bw.flush();
        bw.close();
    }
}
