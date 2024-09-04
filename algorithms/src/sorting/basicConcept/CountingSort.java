package sorting.basicConcept;

public class CountingSort {
    // カウンティング整列とは？
    // 値が何度出てきたかを測定してみる。
    // 例えば、7 9 1 2 5 11 12 1 2 7 こんなものがある

    // counting[1] = 2, counting[2] = 2, counting[5] = 1
    // counting[7] = 2, counting[9] = 1
    // counting[11] = 1, counting[12] = 1

    // で、counting[]配列の2番目の要素から、１番目からの累積合計に置き換えるのだ。
    // すると。。

    // [1]=2, [2]=2, [5]=1, [7]=2, [9]=1, [11]=1, [12]=1　なのだろうが
    // これらは既に数字の大きさ順で数字が何個ずつあるかを示しているよな

    // 1,1,2,2,5,7,9,11,12にすれば整列や
    // [2]の位置はどこにするべきか？[1]の位置の後だ。2+2=4
    // [5]の位置は？[1]の位置、[2]の位置の後だ。2+2+1=5

    // だから、累積合計にcounting[]配列の値を書き換える
    // 2, 2, 1, 2, 1, 1, 1は
    // [1]=2, [2]=4, [5]=5, [7]=7, [9]=8, [11]=9, [12]=10になるね
    // 再度元の配列7 9 1 2 5 11 12 1 2 7に戻り。。

    // 同じ値がいくつもある場合はどうなるのか？counting[]のvalueを減らせばいい。
    // int i=0;
    // arr[i]==7, counting[7]==7
    // 7の位置は？answer[6]にする。１つ配置したから引き算しとく。
    // counting[7] -= 1;
    // またarr[i]が7の時にこれをやれば今度は他の7がanswer[5]に入る
    public static void main(String[] args) {
        // arrayのmaxは100未満の条件があるとする
        int[] arr = new int[]{1,1,1,5,2,4,6,0,99,22,11,95,23,14,55,39,77,88,53,19,19,42,83};
        // int[] arr = new int[]{5,4,3};
        // countingArrayを設ける
        int[] counting = new int[100];

        // まず、arrの値が何個あるか格納していく
        for(int i=0; i<arr.length; i++){
            counting[arr[i]] += 1;
        }
        // 配列countingの値を累積合にしておく
        for(int j=0; j<99; j++){
            counting[j+1] += counting[j];
        }
        // arrの各値を巡回し、countingにより配置していく
        int[] answer = new int[arr.length];
        for(int k=arr.length-1; k>-1; k--){
            // 逆順で作る：上書きを防止する
            answer[counting[arr[k]]-1] = arr[k];
            counting[arr[k]] -= 1;
        }
        // 出力
        StringBuilder sb = new StringBuilder();
        for(int m=0; m<arr.length; m++){
            sb.append(arr[m]+" ");
        }
        sb.deleteCharAt(sb.lastIndexOf(" "));
        sb.append("\n");
        for(int n=0; n<arr.length; n++){
            sb.append(answer[n]+" ");
        }
        sb.deleteCharAt(sb.lastIndexOf(" "));
        System.out.println(sb);
    }
}