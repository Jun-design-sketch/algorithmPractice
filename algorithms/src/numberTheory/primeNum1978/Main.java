package numberTheory.primeNum1978;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 0 <= n <= 100
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        String numAll = br.readLine();
        StringTokenizer st = new StringTokenizer(numAll, " ");
        for(int i=0; i<n; i++){
            // 1 <= case <= 1000
            int c = Integer.parseInt(st.nextToken());
            int primeCount = 0;
            for(int j=1; j<=c; j++){
                if(c%j ==0 ) primeCount++;
            }
            if(primeCount == 2) count++;
        }
        br.close();
        bw.write(""+count);
        bw.flush();
        bw.close();
    }
}
