package sorting.numSort1427;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // num max = 1000000000なのでintで十分
        String[] str = br.readLine().split("");
        int[] arr = new int[str.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        // 再度countingSortをやってみる。今回は0~9の間になるからcountingで十分
        int[] count = new int[10];
        // まずは各数字を数える
        for(int i=0; i<arr.length; i++){
            count[arr[i]] += 1;
        }
        // 数えたものの数を累計合にしておく。が、昇順でなく降順にしたいから逆に累計
        for(int j=count.length-1; j>0; j--){
            count[j-1] += count[j];
        }
        // 配置する。
        int[] answer = new int[str.length];
        // for(int k=arr.length-1; k>-1; k--){ // arrの値を辿る
        for(int k=0; k<arr.length; k++){
            int value = arr[k]; // 再配置したい値
            int position = count[value]; // 再配置すべき場所
            answer[position-1] // answerのpositionに ※0から始まる配列特徴上-1せんと
            = value; // valueを置く
            count[value] -= 1; // 位置においたので1を引いておく。
        }

        StringBuilder sb = new StringBuilder();
        for(int m=0; m<answer.length; m++){
            sb.append(answer[m]);
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}