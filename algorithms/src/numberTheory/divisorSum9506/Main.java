package numberTheory.divisorSum9506;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        String answer;
        StringBuilder sb = new StringBuilder();
        // 各列にnが与えられる。nは完全数か？最後の列は−1が与えられる
        while((n = Integer.parseInt(br.readLine())) != -1){
            int divisorSum = 0;
            for(int i=1; i<n; i++){
                if(n%i == 0) {
                    sb.append(i+" + ");
                    divisorSum += i;
                }
            }
            if(divisorSum==n){
                String str = sb.toString();
                answer = n + " = " + str.substring(0,str.length()-3);

            }else{
                answer = n+" is NOT perfect.";
            }
            sb.setLength(0);
            bw.write(answer+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
