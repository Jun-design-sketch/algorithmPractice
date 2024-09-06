package sorting.basicConcept;

public class SelectionSort {
    // 選択整列
    // 現在位置に入るべきデータを探して選択するアルゴリズム
    // データの比較しながら探すため、比較整列である。
    // 整列の対象になるデータ外に追加的な空間を必要としないため、in-place sortともいう。
    // データを交換する過程(swap)で臨時変数は要るけれど、無視するほど少ない
    // そして、不安定整列である。
    public static void main(String[] args) {
        // 与えられたリストで最小値を見つける。
        // 最小値を最初の値と交換する。
        // また残りのうち、最小値を見つけ２番目の値と交換する。
        // ...
        int[] arr = new int[]{1,2,99,42,15,393,0,333,222,-22,11,-444,-555,223,221,774};

        StringBuilder sb = new StringBuilder();
        for(int k=0; k<arr.length; k++){
            sb.append(arr[k]+" ");
        }
        // sb.deleteCharAt(sb.lastIndexOf(" "));
        sb.setLength(sb.length() - 1);
        sb.append("\n");

        int minIndex = 0;
        int temp = 0;
        for(int i=0; i<arr.length-1; i++){ // n-1個交換したら最後の残りは最大値だから
            int min = Integer.MAX_VALUE;
            // minを探しておこう
            for(int j=i; j<arr.length; j++){
                if(arr[j] <= min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 探し終わったら交換する
            temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }

        for(int l=0; l<arr.length; l++){
            sb.append(arr[l]+" ");
        }
        // sb.deleteCharAt(sb.lastIndexOf(" "));
        sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }
    // メモリの追加消耗があまりない。
    // ただ、O(N^2)である
    // 安定整列ではない
    // とは？最初の順番が維持されないのだ。
    // 名前で整列したあと、成績で整列するとかをしたら同じ点数内で名前の順番は維持したいはずだけど
    // これで点数順整列を行うと同点数内での名前順が変わってしまう可能性がある
}
