package sorting.numSort2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
    // Quick pivot
    // つまり。。
    // 1 9 2 4 5 6 8 100、pivot = arr(middle) == 5
    // 5より少ないものを全部左に送る、5より大きいものを全部右に送る
    // 1 2 4 5 9 6 8 100
    // 1,2,4   9,6,8,100

    // 1,2,4
    // 2がpivot
    // 1,4は既に条件を満たしている

    // 9,6,8のpivotは6
    // 6,8,9
    // 8,9でpivotを9にすると8は既に左側。

    // これらの結果を組み合わせると整列完了。

    // ただ、これをコードにすると頭でやる時より面倒になる
    // ①後から配列を合体させるのがだるい
    // ②少ないものを左に送るのがだるい
    // ③大きいものを右に送るのがだるい
    // だから、①：配列はそのままにする　②、③：それらの位置を交換してしまいえばいい
    // 最終的に

    // pivotを１つ選択する。(真ん中）
    // pivotを基準として両方でpivotより大きい値（左:low）、少ない値（右:high）を探す。
    // あればlowとhighの位置を入れ替える (while句 + swap)
    // 左で探索する位置、右で探索する位置のすれ違いがない限度までこれを繰り返す。(if lo>=hi return hi)
    // すれ違った時点を基準とし、２つの部分リストに分ける。(loを引数に分離し再帰的実行）
    // これらの部分リストの長さが１になるまでpivot選定〜交換〜すれ違い発生までを繰り返す。
    // 隣接した部分リスト同士で合体する。(①：何もしなくていい）

    // で、最悪の条件でない(既に1,2,3,4,5だったりはO(n^2))限り。。
    // 1段階：O(n)
    // 2段階：2 * O(n/2) = O(n)
    // ...
    // これをn/2^k回繰り返すから深さはlognになる。
    // n * log nなのでO(nlogn)だ。
    public static void main(String[] args) throws IOException {
        QuickSort qs = new QuickSort();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        5
//        5
//        4
//        3
//        2
//        1
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(br.readLine());
            sb.append(a[i]+" ");
        }
        sb.append("\n");

        // pivotを実行する。配列、minIndex, maxIndexを渡す
        qs.m_pivot_sort(a, 0, a.length-1);

        for(int i=0; i<n; i++){
            sb.append(a[i]+" ");
        }
        System.out.println(sb);
    }
    private void m_pivot_sort(int[] a, int lo, int hi) {
        // lo < hiの場合実行する。
        if(lo < hi) {
            // partitionを呼び出し、現在配列のloからhiまでの範囲を分割する。
            // pivotを得る過程で、最初の配列半分時点をpivotにして元素交換をする。
            // partition{ int pivot }により全ての交換が完了されたら減少したhiをポインタでここへ戻る。
            int pivot = partition(a, lo, hi);
            // 減少したhiから左半分
            m_pivot_sort(a, lo, pivot);
            // 減少したhiから右半分
            m_pivot_sort(a, pivot + 1, hi);
        }
        // recursiveに2回、左と右に更新されるpivot(==減少するhi＝=ポインター)を呼び出すから
        // 何度も呼び出されるm_pivot_sortで与えられるloが増加し、hiが減少するといずれlo>=hiになり終了する
    }

    private int partition(int[] a, int left, int right) {
        // loとhiはポインタとして考える
        int lo = left-1; // lo++するから-しとく
        int hi = right+1; // hi--するから+しとく
        int pivot = a[(left+right)/2]; // middle
        while(true){
            // a[lo]がpivotより少ないうち、ずっと実行する：a[lo] >= pivotで終了
            do{ lo++; }while(a[lo] < pivot);
            // a[hi]がpivotより大きいうち、ずっと実行する。また、loがhiを超えないこと。：a[hi] <= pivotで終了
            do{ hi--; }while(a[hi] > pivot && lo <= hi);
            // loがhi以上になれば、hiを返す。
            // loポインタとhiポインタが遭遇したから探索は完了
            // ここでhighを返すことで、後続の分割された左・右実行の基準点を提供できる
            if(lo>=hi) return hi;
            // そうでなければ、a[lo]とa[hi]の位置を交換しまた回る
            // ここに来る時点で a[hi] <= pivot <= a[lo]だから交換すべき
            swap(a, lo, hi);
        }
    }

    private void swap(int[] a, int i, int j){
        // 要素を交換する
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
