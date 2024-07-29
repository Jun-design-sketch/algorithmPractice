package iterationAdd2;

import java.io.*;

public class Main {
    public static final String CASE_STR_HEAD = "Case #";
    public static final String CASE_STR_TAIL = ": ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            String str[] = br.readLine().split(" ");
            int add = Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
            bw.write(CASE_STR_HEAD+i+CASE_STR_TAIL+add+"\n");
        }
        bw.flush();
        bw.close();
    }
}
