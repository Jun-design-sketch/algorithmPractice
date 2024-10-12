package sorting.basicConcept;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MergeSort {
    // マージソート
    // Mergeは合併、統合すること。
    // 名柄が似ている分割統治法（Divide and Conquer）の具現として考えても良い

    // 分割統合法
    // 分割：問題をいくつかの下位問題に分ける
    // 征服：各下位問題を再帰的に解消する
    // 結合：下位問題の結果を組み上げ、最終結果を生成する

    // マージソート
    // 分割：配列を中間のインデックスを基準とし、２つの下位配列に分ける。
    // 征服：各下位配列を再帰的にマージソートし、整列する。
    // 結合：全ての下位配列を結合し全体配列を完成する。
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ランダムな配列を作る
        int[] arr = new int[10];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            arr[i] = (int) (Math.random() * 100);
            sb.append(arr[i]+" ");
        }
        sb.setLength(sb.length()-1);
        sb.append("\n");

        // java.utilにmergeSort()メソッドは既にある。。
        merge_sort(arr, 0, arr.length-1);
        for(int j=0; j<arr.length; j++){
            sb.append(arr[j]+" ");
        }
        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void merge_sort(int[] arr, int left, int right) {
        if(left == right) return; // 左右が同じになると何もしない
        int middle = (left + right) / 2;
        merge_sort(arr, left, middle); // 左半分 => 更に半分、半分、半分、、、し32行でreturn;される
        merge_sort(arr, middle+1, right); // 右半分 => 同様
        // ここに来たら、arr全量を再帰的ループした後（左＝右）
        merge(arr, left, middle, right);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[arr.length];
        int l = left;
        int r = middle + 1;
        int index = left;
        // 左の部分[l]が右の部分[r]より少ない・同じである場合、
        // 左の部分[l]を新しい配列に入れる。lとidxを１増やす
        // その逆なら右の部分に同じことをする
        while(l <= middle && r <= right) {
            if(arr[l] <= arr[r]){
                temp[index] = arr[l];
                index++;
                l++;
            }else{
                temp[index] = arr[r];
                index++;
                r++;
            }
        }
        // 左だけ余った時、右だけ余った時はそれぞれ残りを処理してあげる
        if(l > middle) {
            while(r <= right) {
                temp[index] = arr[r];
                index++;
                r++;
            }
        }else{
            while(l <= middle) {
                temp[index] = arr[l];
                index++;
                l++;
            }
        }

        for(int i=left; i<=right; i++){
            arr[i] = temp[i];
        }
    }
}
