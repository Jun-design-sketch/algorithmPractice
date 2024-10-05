package numberTheory.primeNumber4948;

import java.io.*;

public class Main {
    // Bertand's Postulate バートランドの予想
    // とある自然数nに対して、n超過と2n以下の間には常に少なくとも１つの素数が存在する
    // 与えられる各ケースの自然数nに対して、n超過と2n以下の間にある素数の数を返却する
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n;
        while((n = Integer.parseInt(br.readLine())) != 0) {
            int count = 0;
            for(int i=n+1; i<=n*2; i++){
                if(isPrime(i)) count++;
            }
            sb.append(count+"\n");
        }
        br.close();
        sb.setLength(sb.length()-1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean isPrime(int target) {
        int limit = (int) Math.sqrt(target);
        for(int i=2; i<=limit; i++){
            if(target % i == 0) return false;
        }
        return true;
    }
}
