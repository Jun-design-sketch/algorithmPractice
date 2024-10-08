package combinatorics.greenTower24723;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int ans = (int) Math.pow(2, n);
        System.out.println(ans);
    }
}
