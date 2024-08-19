package string.string5622;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int ASCII_A = 65;
    public static int ASCII_Z = 90;

    // firstAnswer
    public static void main(String[] args) throws IOException {
        Main main = new Main();
//        main.firstAnswer();
        main.secondAnswer();
    }

    public void firstAnswer() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // telMap
        Map<String, Integer> telMap = new HashMap<>();
        for(int i=0; i<ASCII_Z-ASCII_A+1; i++){
            int charAsciiCode = ASCII_A+i;
            char key = (char)charAsciiCode;
            int value = (i/3)+2;
            // ABC, DEF, GHI, JKL, MNO
            if(value < 7) {
                // telMap(alphabet, durationTime)
                telMap.put(String.valueOf(key), value+1);
                // PQRS
            }else if(14 < i && i < 19){
                telMap.put(String.valueOf(key), 7+1);
                // TUV
            }else if(18 < i && i < 22){
                telMap.put(String.valueOf(key), 8+1);
                // WXYZ
            }else{
                telMap.put(String.valueOf(key), 9+1);
            }
        }
        // convert alphabet to durationTime
        char[] telAlphabets = br.readLine().toCharArray();
        int answer = 0;
        for(int i=0; i<telAlphabets.length; i++){
            answer += telMap.get(String.valueOf(telAlphabets[i]));
        }
        // output
        bw.write(""+answer);
        br.close();
        bw.flush();
        bw.close();
    }

    public void secondAnswer() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] telAlphabets = br.readLine().toCharArray();
        int answer = 0;
        // ASCII compare
        for(int i=0; i<telAlphabets.length; i++){
            if(telAlphabets[i] <= 'C') answer += 3;
            else if(telAlphabets[i] <= 'F') answer += 4;
            else if(telAlphabets[i] <= 'I') answer += 5;
            else if(telAlphabets[i] <= 'L') answer += 6;
            else if(telAlphabets[i] <= 'O') answer += 7;
            else if(telAlphabets[i] <= 'S') answer += 8;
            else if(telAlphabets[i] <= 'V') answer += 9;
            else answer += 10;
        }
        // output
        bw.write(""+answer);
        br.close();
        bw.flush();
        bw.close();
    }

}
