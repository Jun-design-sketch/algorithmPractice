package beginner.number4101;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = br.readLine()) != null) {
            String[] arr = line.split(" ");
            int i = Integer.parseInt(arr[0]);
            int j = Integer.parseInt(arr[1]);

            if(i == 0 && j == 0) break;

            if(i > j) sb.append("Yes\n");
            else sb.append("No\n");
        }
        br.close();

        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
