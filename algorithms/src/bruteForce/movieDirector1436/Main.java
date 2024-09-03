package bruteForce.movieDirector1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Test solution = new Test();
        // solution.sol1();
        solution.sol2();
    }
}

class Test {
    protected void sol2() throws IOException {
        // シンプルに全部１ずつ増やしながら数える。
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int start = 666;
        int count = 0;
        while(count != n){
            String val = String.valueOf(start);
            if(val.contains("666")){
                count++;
            }
            start++;
        }
        start--; // countを満たしループを抜ける時も+1されるため
        System.out.println(start);
    }

    protected void sol1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        // "666"を含むN番目に少ない数字を求めよ。

        // 666の前と後に何をどれくらいおくか？
        // 666を除いて考えてみる
        // ２つの袋がある。袋に入れるものの数は最低０。最高全量。
        // 組合と順列の話になるのでは？

        // 多分、配列に入れる考え方ではいけないのかもしれない
        // 前回のものと今回のものを比べる？
        //

        // 666を含む：666の前に足すか、後ろに足すか
        int count = n-1; // 1番目に少ないのは666なので-1
        int[] arr = new int[2*n+1];
        int target = 666;
        arr[0] = target;
        for(int i=1; i<=n; i++){
            // 1: 666の前に数字を入れる場合、10の何乗掛け算するか：nの値が10の何乗かによって増やす
            int cur = i;
            int digit = 0;
            int checkDigit = i;
            while(checkDigit/10!=0){
                digit++;
                checkDigit /= 10;
            }
            // 頭もしくは尻尾に全量つける場合
            // 頭につける場合、curは既に10の乗数を含む
            int headAdd = (int) (cur*Math.pow(10,3)) + target;
            // 尻尾につける場合、curが既に10の乗数を含む分targetに掛ける乗数を増やす
            int tailAdd = (int) ((target*Math.pow(10,digit+1)) + cur);
            // 2: 等差数列で増加するiに対して、等倍数列で増加する配列を挿入する
            arr[cur*2-1]=headAdd;
            arr[cur*2]=tailAdd;

            //頭と尻尾に分けてつける場合
            //
        }
        System.out.println("ha...");
        Arrays.sort(arr);
        // 3: 配列の重複を如何に排除するか？
        System.out.println(arr[count]);
    }
}
