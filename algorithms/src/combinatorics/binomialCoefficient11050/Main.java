package combinatorics.binomialCoefficient11050;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 自然数nとkに対して、二項係数(n,k)を求めよ
    // N個のもののうち、K個を順番なく選ぶ場合分けと同じ

    // 普通にk個を選ぶ場合だと、n*(n-1)...(n-k+1)だが
    // 順番関係ななのでk個の重複分k!
    // n! / k!(n-k)!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = getFactorial(n) / (getFactorial(k) * getFactorial(n-k));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static int getFactorial(int target) {
        int factorialVal = 1;
        if(target > 1){
            while(target != 1){
                factorialVal *= target;
                target--;
            }
        }
        return factorialVal;
    }
}
