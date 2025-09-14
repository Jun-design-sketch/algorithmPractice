package beginner.word1264;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String vowels = "AEIOUaeiou";
        String line;
        while((line = br.readLine()) != null) {
            if(line.equals("#")) break;
            String[] arr = line.split("");
            int count = 0;
            for(int i = 0; i < line.length(); i++) {
                if(vowels.indexOf(arr[i]) != -1) count++;
            }
            sb.append(count+"\n");
        }
        br.close();

        if(sb.length() > 0) sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
