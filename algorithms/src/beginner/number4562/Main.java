package beginner.number4562;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Zombies love to eat brains. Yum.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int waves = Integer.parseInt(br.readLine());
        for(int i = 0; i < waves; i++) {
            String[] arr = br.readLine().split(" ");
            String situation = Integer.parseInt(arr[0]) < Integer.parseInt(arr[1]) ? "NO BRAINS\n" : "MMM BRAINS\n";
            sb.append(situation);
        }
        br.close();

        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
