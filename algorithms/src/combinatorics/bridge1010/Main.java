package combinatorics.bridge1010;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int caseCount = Integer.parseInt(br.readLine());

        for(int i=0; i<caseCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            // n! / (n-k)! * k!
            BigInteger answer = getFactorialLimitVer(n, k).divide(getFactorialLimitVer(k, k-1));
            sb.append(answer +"\n");
        }
        br.close();
        sb.setLength(sb.length()-1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static BigInteger getFactorialLimitVer(int n, int k) {
        // n! / (n-k)!
        BigInteger factor = BigInteger.valueOf(n);
        BigInteger limit = BigInteger.valueOf(n).subtract(BigInteger.valueOf(k));
        BigInteger result = BigInteger.ONE;

        if(factor.equals(BigInteger.ONE)) return BigInteger.ONE;

        while(true) {
            result = result.multiply(factor);
            factor = factor.subtract(BigInteger.ONE);
            if(factor.equals(limit)) break;
        }
        return result;
    }
}
