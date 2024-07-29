package iterationAdd3;

import java.io.*;

public class Main {
    public static final String CASE_STR_HEAD = "Case #";
    public static final String CASE_STR_TAIL = ": ";
    public static final String ADD_OPERATOR = " + ";
    public static final String EQUAL_OPERATOR = " = ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            String str[] = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int addResult = a+b;
            bw.write(CASE_STR_HEAD+i+CASE_STR_TAIL+a+ADD_OPERATOR+b+EQUAL_OPERATOR+addResult+"\n");
        }
        bw.flush();
        bw.close();
    }
}

