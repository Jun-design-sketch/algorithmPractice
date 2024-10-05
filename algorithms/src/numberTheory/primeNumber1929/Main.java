package numberTheory.primeNumber1929;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        br.close();

        StringBuilder sb = new StringBuilder();
        for(int i=min; i<=max; i++) {
            if(isPrime(i)) sb.append(i+"\n");
        }
        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean isPrime(int target) {
        if(target <= 1) return false;
        else if(target == 2) return true;

        int limit = (int) Math.sqrt(target);
        for(int i=2; i<=limit; i++){
            if(target % i == 0) return false;
        }
        return true;
    }
}
class Solution {

    protected void sol1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        br.close();

        // min <= element <= maxの配列
        int[] arr = new int[max-min+1];
        int index = 0;
        for(int i=min; i<=max; i++){
            arr[index] = i;
            index++;
        }
        // 素数であれば、素数の倍数を全て0に入れ替える
        for(int i=min; i<=max; i++){
            if(isPrime(i)){
                int rolling = 1;
                while(i-min+(rolling*i) <= arr.length-1){
                    arr[i-min+(rolling*i)] = 0;
                    rolling++;
                }
            }else{
                arr[i-min] = 0;
            }
        }
        // 出力
        for(int j=0; j<arr.length; j++){
            if(arr[j] != 0) sb.append(arr[j]+"\n");
        }
        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean isPrime(int target) {
        if(target <= 1) return false;
        else if(target == 2) return true;

        boolean result = true;
        int divisor = target-1;

        int limit = (int) Math.sqrt(target);
        while(limit <= divisor){
            if(target % divisor == 0){
                result = false;
                break;
            }
            divisor--;
        }
        return result;
    }
}