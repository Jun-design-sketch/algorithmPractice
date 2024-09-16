package numberTheory.leastCommonMultiple13241;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 再度 GCD(A,B)＝＝GCD(B,r)であることを用いる。
    // A>=Bであることに注意しよう
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        br.close();
        Gcd gcdIns = new Gcd(a,b);
        int gcd = gcdIns.getGcd();
        if(a > 1000){
            long answer = (long)a*b/gcd;
            System.out.println(answer);
        }else{
            int answer = a*b/gcd;
            System.out.println(answer);
        }
    }
}

class Gcd {
    private final int a;
    private final int b;

    Gcd(int a, int b){
        this.a = a;
        this.b = b;
    }
    protected int getGcd(){
        int[] arr = new int[]{a, b};
        Arrays.sort(arr);
        int bigger = arr[1];
        int smaller = arr[0];
        while(smaller!=0){
            int tmp = bigger;
            bigger = smaller;
            smaller = tmp%smaller;
        }
        return bigger;
    }
}
