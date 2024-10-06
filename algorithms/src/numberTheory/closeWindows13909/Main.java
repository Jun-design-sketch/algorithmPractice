package numberTheory.closeWindows13909;

import java.io.*;
import java.util.HashMap;

public class Main {
    // 開いている窓の数を求めよ
    // 初期状態で全ての窓は閉されている
    // 1番目の人は１の倍数の窓を開ける
    // 2番目の人は２の倍数の窓を閉じる
    // ...
    // 最後に開いている窓の数は？
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 窓の数
        int n = Integer.parseInt(br.readLine());
        br.close();

        int count = 0;
        for(int i=1; i<=n; i++){
            HashMap<Integer, Integer> process = countDivisor(i);
            // TODO: ここから
            int countDivisor = countPrimeFactor(i)+1;
            if(countDivisor == 2) count++;
            else if(countDivisor+1 % 2 == 1) count++;
        }
        // 開いてる窓の数を出力する
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    public static HashMap<Integer, Integer> countDivisor(int target) {
        if(target == 1){
            return null;
        }
        else{
            int divisor = 1;
            HashMap<Integer, Integer> map = new HashMap<>();
            while(true){
                divisor++;

                if(target % divisor == 0){
                    target /= divisor;

                    if(map.containsKey(divisor)) map.put(divisor, map.get(divisor)+1);
                    else map.put(divisor, 1);
                    divisor = 1;
                    if(target == 1) break;
                }
            }
        }
    }

    public static int countPrimeFactor(int target) {
        if(target == 1) return 0;

        int count = 0;
        int divisor = 1;

        while(true){
            divisor++;

            if(target % divisor == 0){
                target /= divisor;
                count++;
                divisor = 1;
                if(target == 1) break;
            }
        }
        return count;
    }
}
