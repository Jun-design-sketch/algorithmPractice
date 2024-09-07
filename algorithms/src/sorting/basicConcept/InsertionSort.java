package sorting.basicConcept;

public class InsertionSort {
    public static void main(String[] args) {
        // 挿入整列
        // 現在比較しようとしているターゲットと、それ以前の元素と比較し場所を交換する。
        // データを比較しながら探すため「比較整列」である
        // 整列の対象となるデータ以外、追加空間を必要としないためin-place sortでもある。
        // 選択整列とは違い、挿入整列は安定整列。

        // まとめ
        // 任意の配列 { a, b, c, d ,e ,.. }
        // 最初はbとaを比較する。bがaより少なければaとbの位置を入れ替える。
        // 次はcとbを比較する。cがbより少なければcとbの位置を入れ替える。また(入れ替わった）bとaを比較する、…
        // これらの繰り返しの途中、入れ替え不要があったらそれ以降は入れ替え確認不要。
        // 入れ替え不要になった時点での比較対象が、残り比較対象全てのうち最大の値なのだから

        int[] arr = new int[]{1,2,-44,-99,93,1,222,212,22,99,555,33,292,41,4};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]+" ");
        }
        sb.setLength(sb.length()-1);
        sb.append("\n");

        for(int i=1; i<arr.length; i++){
            // ここはwhile文に書き換えることができる。。
//            for(int j=i; j>0; j--){
//                int tmp = arr[j-1];
//                if(arr[j]<arr[j-1]){
//                    arr[j-1] = arr[j];
//                    arr[j] = tmp;
//                }else{
//                    break;
//                }
//            }
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]+" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
