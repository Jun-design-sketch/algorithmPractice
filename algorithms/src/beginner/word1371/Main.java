package beginner.word1371;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26];
        String line;
        while((line = br.readLine()) != null){
            for(int i=0; i<line.length(); i++) {
                char eachWord = line.charAt(i);
                if(eachWord != ' ') {
                    int position = (int)eachWord - 97;
                    arr[position] += 1;
                }
            }
        }
        br.close();

        int max = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==max) {
                int eachWord = i + 97;
                char convertedWord = (char)eachWord;
                sb.append(convertedWord);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
