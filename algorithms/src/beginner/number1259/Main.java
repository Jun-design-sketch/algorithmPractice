package beginner.number1259;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = br.readLine()) != null) {
            if(line.equals("0")) break;

            // StringBuilder sb2 = new StringBuilder(line).reverse(); すれば簡単
            String[] arr = line.split("");
            StringBuilder sb2 = new StringBuilder();
            for(int i=arr.length-1; i>=0; i--) {
                sb2.append(arr[i]);
            }

            if(sb2.toString().equals(line)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        br.close();

        if(sb.length() > 0) sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
