package combinatorics.factorial10872;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int answer = 1;
        if(n > 1){
            while(n != 1){
                answer *= n;
                n--;
            }
        }else{
            answer = 1;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
