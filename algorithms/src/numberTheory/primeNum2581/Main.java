package numberTheory.primeNum2581;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        br.close();
        int minimum = 0;
        int sum = 0;
        int count = 0;
        for(int i = m; i <= n; i++){
            int primeCount = 0;
            for(int j = 1; j <= i; j++){
                if(i % j == 0) primeCount++;
                if(primeCount > 2){
                    primeCount = 0;
                    break;
                }
            }
            if(primeCount == 2){
                count++;
                if(count == 1){
                    minimum = i;
                }else{
                    sum += i;
                }
            }
        }
        if(count == 0){
            bw.write("-1");
        }else{
            sum += minimum;
            bw.write(""+sum+"\n"+minimum);
        }
        bw.flush();
        bw.close();
    }
}
