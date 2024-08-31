package bruteForce.decomposition2231;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Sol sol = new Sol();
        // sol.sol1();
        sol.sol2();
    }
}

class Sol {
    // 最小の値を求めているので、i--ループよりi++ループが良かった
    protected void sol2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine();
        br.close();
        // 各桁の数字合計を引き算する
        int n = Integer.parseInt(strN);
        int answer = 0;
        for(int i=0; i<n; i++){
            int number = i;
            int sum = 0;
            // 各桁数の合計を求める
            while(number != 0){
                sum += number % 10;
                number /= 10;
            }
            if(sum + i == n){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
    protected void sol1() throws IOException {
        // 분해합 分解和 decomposition
        // とある自然数Nに対して、Nの分解和はNとNを構成する各桁の数の合計。
        // 245の分解和＝256（＝245＋2＋4＋5）。
        // Mの分解和がNの場合、MをNの生成者という。
        // 256の生成者=245.

        // 与えられたNに対してNの一番小さい生成子を求めよ。
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine();
        br.close();
        // 各桁の数字合計を引き算する
        int n = Integer.parseInt(strN);
        String[] nArr = strN.split("");
        int digitSum = 0;
        for(int i=0; i<nArr.length; i++){
            digitSum += Integer.parseInt(nArr[i]);
        }
        // 生成者のあり得る最大値
        // int constructorMax = n-digitSum; // ここの条件が間違っているかも
        int constructorMax = n-1;
        int constructorMin = 0;
        // 最小の生成者を求める
        for(int j=constructorMax; j>0; j--){
            String[] calDigit = String.valueOf(j).split("");
            int calDigitSum = 0;
            for(int k=0; k<calDigit.length; k++){
                calDigitSum += Integer.parseInt(calDigit[k]);
            }
            if(j+calDigitSum==n) constructorMin = j;
        }
        System.out.println(constructorMin);
    }
}