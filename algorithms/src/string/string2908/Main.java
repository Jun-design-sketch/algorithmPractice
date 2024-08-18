package string.string2908;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] initArr = br.readLine().split(" ");
        // firstNum, secondNum = 3-digits
        char[] firstNum = initArr[0].toCharArray();
        char[] secondNum = initArr[1].toCharArray();
        // compare
        for(int i=2; i>=0; i--){
            if_(firstNum[i] > secondNum[i]){
                bw.write(""+firstNum[2]+firstNum[1]+firstNum[0]);
                break;
            }else if_(firstNum[i] < secondNum[i]){
                bw.write(""+secondNum[2]+secondNum[1]+secondNum[0]);
                break;
            }else{
                // there is no case that firstNum == secondNum
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
