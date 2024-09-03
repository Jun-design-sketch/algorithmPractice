package sorting.numSort2751;

import java.io.*;
import java.util.Arrays;

public class Main {
    // O(nlogn)?
    public static void main(String[] args) throws IOException {
        Test test = new Test();
//        test.sol1();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        test.sol2(arr);


    }
}

class Test {
    // Arrays.sort()の定義を読んでみると、Dual-pivot-sortを使用している
    // 分割制服戦略を使用しており、多くのライブラリ・システムでデフォルト整列アルゴリズムとなっている
    // binarySearchの発想で、配列をnより少ないもの、大きいものに分ける
    // 分けた配列たちに対してrecursiveに再度nを決めbinarySearchを行う。
    protected void sol2(int[] a){
        // Quick pivot
        // pivotを１つ選択する。
        // pivotを基準として両方でpivotより大きい値（左）、少ない値（右）を探す。
        // 値の整列がしたいのだから、これら二つを交換する
        // 左で探索する位置、右で探索する位置のすれ違いがない限度までpivotを固定しこれを繰り返す。
        // すれ違った時点を基準とし、２つの部分リストに分ける。
        // これらの部分リストの長さが１になるまでpivot選定〜交換〜すれ違い発生までを繰り返す。
        // 隣接した部分リスト同士で合体する。
    }


    // 内蔵関数
    protected void sol1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<n; j++){
            sb.append(arr[j]);
            if(j!=n-1){
                sb.append("\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
