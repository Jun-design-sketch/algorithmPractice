package iterationStarReverse;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        // add all "*"
        int starNumberAll = n%2 == 0 ? (n+1)*(n/2) : (n+1)*(n/2)+(n+1)/2;
        String rStr = "*".repeat(starNumberAll);
        sb.append(rStr);
        // add all " "
        int position = 0;
        for(int i = n; i>0; i--){
            String rStr2 = " ".repeat(i-1);
            sb.insert(position, rStr2);
            position += n;
        }
        // insert \n
        int position2 = n;
        for(int i = 0; i < n; i++){
            sb.insert(position2, "\n");
            // \n is 1 character
            position2 += n+1;
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
