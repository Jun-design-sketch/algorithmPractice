package backTracking.cal14888;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static public int[] arr;
    // static public int[] operators = new int[4];
    static public int MAX_VALUE;
    static public int MIN_VALUE;
    // static public int curVal;
    static public int limit;
    public static void main(String[] args) throws IOException {
        // 与えられた式の結果での最大値を１行目、最小値を２行目に出力せよ
        // 数字の順番を変更不可
        // 演算子の優先順位を無視し、前から演算する
        // 割り算は定数の割り算で、残りを捨てる。：符号を＋に変えて割り算結果を-に変える
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

    /*
    ** 一度使用した数字は再使用できず、数字の順番が変えられないため
    ** 全ての場合分けを考えると樹形図になり、記号が可変因子
    ** １つの枝が最後まで進んだら、２段階前に戻り別のケースを確認すればいい
    ** 3段階前なら？
     */

    // テストコード
    public static int count = 0;

    public static void eachStep(int curVal, int[] operators, int depth, int i) {
        // 最後まで計算していたら
        if(depth == limit){
            if(MAX_VALUE < curVal) MAX_VALUE = curVal;
            if(MIN_VALUE > curVal) MIN_VALUE = curVal;
            //テストコード
            count++;
            System.out.println(MAX_VALUE+" "+MIN_VALUE+" "+count);
            return;
        }
        // TODO: 以前段階に戻らせ、他の選択肢を選ばせる => 戻らせるより再帰関数に打ち込んで初期化、また次の再帰関数にする
        // どの演算子を入れるか
        i++;
        if(operators[0] > 0) {
            curVal += arr[i];
            operators[0]--;
            eachStep(curVal, operators, depth+1, i);
            operators[0]++;
            curVal = arr[0];
        }
        if(operators[1] > 0) {
            curVal -= arr[i];
            operators[1]--;
            eachStep(curVal, operators, depth+1, i);
            operators[1]++;
            curVal = arr[0];
        }
        if(operators[2] > 0) {
            curVal *= arr[i];
            operators[2]--;
            eachStep(curVal, operators, depth+1, i);
            operators[2]++;
            curVal = arr[0];
        }
        if(operators[3] > 0) {
            if(curVal < 0) {
                curVal = (curVal * (-1) / arr[i]) * (-1);
            }else {
                curVal = curVal / arr[i];
            }
            operators[3]--;
            eachStep(curVal, operators, depth+1, i);
            operators[3]++;
            curVal = arr[0];
        }
    }
}