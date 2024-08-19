package deepening.starPrint2444;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        int numWhitespace = n-1;
        int numStarLeftAndMiddle = 1;
        int numStarRight = 0;

        // make each line: ~half
        String[] forHalf = new String[n];
        for(int i=0; i<n; i++){
            forHalf[i] = (" ".repeat(numWhitespace)
                    +"*".repeat(numStarLeftAndMiddle)
                    +"*".repeat(numStarRight));
            numWhitespace -= 1;
            numStarLeftAndMiddle += 1;
            numStarRight += 1;
        }
        // append each line: ~half
        for(int i=0; i<n; i++){
            sb.append(forHalf[i]);
            sb.append("\n");
        }
        // append each line: half+1~end
        for(int i=n-1; i>0; i--){
            sb.append(forHalf[i-1]);
            if(i != 1){
                sb.append("\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
