package iterationStar;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        // make all stars
        int starNumberAll = n%2 == 0 ? (n+1)*(n/2) : (n+1)*(n/2)+(n+1)/2;
        for(int i = 0; i < starNumberAll; i++){
            sb.append("*");
        }
        // insert \n
        int position = 0;
        for(int i = 1; i <= n; i++){
            position += i;
            int accumulation = position + 1*(i-1);
            sb.insert(accumulation, "\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
