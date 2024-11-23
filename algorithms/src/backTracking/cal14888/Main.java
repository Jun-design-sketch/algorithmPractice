package backTracking.cal14888;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static public int[] arr;
    static public int MAX_VALUE;
    static public int MIN_VALUE;
    static public int limit;
    // 与えられた式の結果での最大値を１行目、最小値を２行目に出力せよ
    // 数字の順番を変更不可
    // 演算子の優先順位を無視し、前から演算する
    // 割り算は定数の割り算で、残りを捨てる。：符号を＋に変えて割り算結果を-に変える
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 数字の数
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 実際の数字
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 使用できる演算子(+, -, *, /)の数
        st = new StringTokenizer(br.readLine());
        int[] operators = new int[4];
        for(int j=0; j< operators.length; j++){
            operators[j] = Integer.parseInt(st.nextToken());
        }
        // 初期値の割り当て
        MAX_VALUE = Integer.MIN_VALUE;
        MIN_VALUE = Integer.MAX_VALUE;
        limit = 0;
        for(int el : operators) limit += el;

        eachStep(arr[0], operators, 0, 0);

        StringBuilder sb = new StringBuilder();
        sb.append(MAX_VALUE).append("\n");
        sb.append(MIN_VALUE);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void eachStep(int curVal, int[] operators, int depth, int i) {
        // 最後まで計算していたら
        if(depth == limit){
            if(MAX_VALUE < curVal) MAX_VALUE = curVal;
            if(MIN_VALUE > curVal) MIN_VALUE = curVal;
            return;
        }
        // どの演算子を入れるか
        i++;
        if(operators[0] > 0) {
            int prevVal = curVal;
            curVal += arr[i];
            operators[0]--;
            eachStep(curVal, operators, depth+1, i);
            operators[0]++;
            // arr[0]に初期化するのではなく直前段階の値に戻す
            curVal = prevVal;
        }
        if(operators[1] > 0) {
            int prevVal = curVal;
            curVal -= arr[i];
            operators[1]--;
            eachStep(curVal, operators, depth+1, i);
            operators[1]++;
            curVal = prevVal;
        }
        if(operators[2] > 0) {
            int prevVal = curVal;
            curVal *= arr[i];
            operators[2]--;
            eachStep(curVal, operators, depth+1, i);
            operators[2]++;
            curVal = prevVal;
        }
        if(operators[3] > 0) {
            int prevVal = curVal;
            if(curVal < 0) {
                curVal *= (-1);
                curVal /= arr[i];
                if(curVal < 0) curVal *= (-1);
            }else {
                curVal /= arr[i];
            }
            operators[3]--;
            eachStep(curVal, operators, depth+1, i);
            operators[3]++;
            curVal = prevVal;
        }
    }
}