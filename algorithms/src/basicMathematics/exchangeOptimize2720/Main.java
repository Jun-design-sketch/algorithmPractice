package basicMathematics.exchangeOptimize2720;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine()); // number of test case

        int[] monetaryUnit = {25,10,5,1}; // okane hosiii...
        // 1dollar = 100cent
        // quarter=25cent, dime=10cent, nickel=5cent, penny=1cent
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            int c = Integer.parseInt(br.readLine());
            for(int j = 0; j < monetaryUnit.length; j++){
                sb.append(c / monetaryUnit[j]);
                if(j != monetaryUnit.length-1){
                    sb.append(" ");
                }else if(i != t-1){
                    sb.append("\n");
                }
                c = c%monetaryUnit[j];
            }
        }
        br.close();
        bw.write(""+sb);
        bw.flush();
        bw.close();
    }
}
