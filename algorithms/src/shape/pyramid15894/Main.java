package shape.pyramid15894;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1<= n <= 10^9
        long n = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(n*4);
    }
}
