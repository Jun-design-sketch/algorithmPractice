package deepening2.bear25192;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        int tail = 0;
        for(int i=0; i<n; i++){
            String line;
            if((line = br.readLine()).equals("ENTER")){
                tail++;
            }
            String result = line + tail;
            set.add(result);
        }
        br.close();

        int answer = set.size() - tail;
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
