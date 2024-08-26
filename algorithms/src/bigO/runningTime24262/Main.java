package bigO.runningTime24262;

public class Main {
    public static void main(String[] args) {
//        MenOfPassion(A[], n) {
//            i = ⌊n / 2⌋;
//            return A[i]; # code1
//        }
        // 1行：与えられたnに対して、code1の遂行数を出力する。
        // 2行：code1の遂行回数を多項式で表した時、最高次項の次数を出力する。
        // ただし、多項式で表せないまたは次数が３より大きければ４を出力する。
        Test test = new Test();
        int[] arr = new int[]{1,2,3,4,5};
        int n = 2;
        test.menOfPassion(arr,n);
        // コードは1回実行されるし、かかる時間は定数のみ
        System.out.println(1);
        System.out.println(0);
        // BigOは、結局どういった法則で繰り返して行くかを表す方法
    }
}

class Test {
    public int menOfPassion(int arr[], int n){
        int i = arr[n/2];
        return arr[i];
    }
}
