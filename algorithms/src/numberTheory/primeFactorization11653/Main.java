package numberTheory.primeFactorization11653;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.sol1();
    }
}

class Solution {
    protected void sol2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();
    }
    protected void sol1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();
        if(n>1){
            // nの約数になり得る値の範囲
            boolean[] arr = new boolean[n+1]; // 0~nまでの配列を作る
            for(int i=0; i<arr.length; i++){
                arr[i] = true;
            }
            // 0~1は素数ではない
            arr[0] = false;
            arr[1] = false;
            // 2~mのうち素数を洗い出す
            for(int i=2; i<arr.length; i++){
                for(int j=2; i*j<=arr.length-1; j++){
                    if(arr[i]==true) arr[i*j]=false;
                }
            }
            // 素数を取得する
            int[] primeNum = new int[n-1];
            for(int i=2; i<arr.length; i++){
                if(arr[i]==true){
                    primeNum[i-2] = i;
                }
            }
            // 割り算を始める
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<primeNum.length; i++){
                while(primeNum[i]!=0&&n%primeNum[i]==0){
                    n/=primeNum[i];
                    sb.append(""+primeNum[i]+"\n");
                }
            }
            sb.delete(sb.length()-1,sb.length());
            bw.write(""+sb);
        }
        bw.flush();
        bw.close();
    }
}
