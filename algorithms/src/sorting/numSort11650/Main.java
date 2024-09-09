package sorting.numSort11650;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1 <= n <= 100,000
        int n = Integer.parseInt(br.readLine());
        // should keep first-sort -> second-sort
        // まず、与えられた条件から２次元配列を考えること。
        // 整列に扱われる数字は２週類与えられるから当然２列にする方が良かった
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            // -100,000<=x,y<=100,000
            String str[] = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        // 2重にソートしようとして上手く書けなかったけれど
        // 元々sort()があるのだから
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    // Integer.compare()の方が安全だけど、今回の例ではintの限度を超えないのでoverflowしない
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });
// こういった内蔵関数の使い方を知るには、中身を見れば良いのであった
// sortの中に入るComparatorのcompare()を見てみると
//        @FunctionalInterface
//        public interface Comparator<T> {
//            /**
//             * Compares its two arguments for order.  Returns a negative integer,
//             * zero, or a positive integer as the first argument is less than, equal
//             * to, or greater than the second.<p>
//             *
//             ...
//             * @param o1 the first object to be compared.
//             * @param o2 the second object to be compared.
//             * @return a negative integer, zero, or a positive integer as the
//             *         first argument is less than, equal to, or greater than the
//             *         second.
//             * @throws NullPointerException if an argument is null and this
//             *         comparator does not permit null arguments
//             * @throws ClassCastException if the arguments' types prevent them from
//             *         being compared by this comparator.
//             */
//            int compare(T o1, T o2);
// compareは最初の引数が２番目の引数より小さい場合は-を、等しい場合は0を、大きい場合は+を返すものだとしっかり書いてあった。。

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(arr[i][0]+" "+arr[i][1]+"\n");
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
