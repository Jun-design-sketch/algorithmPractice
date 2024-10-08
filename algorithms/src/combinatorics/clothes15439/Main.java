package combinatorics.clothes15439;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        // 上と下が違う色である組み合わせは何通りあるか
        System.out.println(n*(n-1));
    }
}