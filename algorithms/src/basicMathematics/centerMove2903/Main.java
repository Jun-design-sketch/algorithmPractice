package basicMathematics.centerMove2903;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int root = (int)Math.pow(2,n) + 1;
        int dot = root * root;
        bw.write(""+dot);
        bw.flush();
        bw.close();
        // 점이 늘어나는 갯수는?
        // 4(초기값) 1개(박스초기값)
        // 9  : 4
        // 25 : 16
        // 박스가 1개일때(실행수0) 박스는 2^0*2^0. 사이에 들어가는 줄은 2^0+1 = 2*2 = 4
        // 박스가 4개일때(실행수1) 박스는 2^1*2^1. 사이에 들어가는 줄은 2^1+1 = 3*3 = 9
        // 박스가 16개일때(실행수2) 박스는 2^2*2^2. 사이에 들어가는 줄은 2^2+1 = 5*5 = 25
        // 박스가 64개일때(실행수3) 박스는 2^3*2^3. 사이에 들어가는 줄은 2^3+1 = 9*9 = 81
        // 박스가 256개일때(실행수4), 박스는 2^4*2^4. 사이에 들어가는 줄은 2^4+1 = 17*17 = 289
        // 박스가 1024개일때(실행수5), 박스는 2^5*2^5. 사이에 들어가는 줄은 2^5+1 = 33*33 =1089
    }
}
