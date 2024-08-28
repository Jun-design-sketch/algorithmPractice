package bigO.runningTime24267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
//        MenOfPassion(A[], n) {
//            sum <- 0;
//            for i <- 1 to n - 2
//            for j <- i + 1 to n - 1
//            for k <- j + 1 to n
//            sum <- sum + A[i] × A[j] × A[k]; # 코드1
//            return sum;
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = BigInteger.valueOf(Integer.parseInt(br.readLine()));
        br.close();
        // i: 1~n-2 = (n-2)回繰り返す。これがjの実行回数総計の計算式に入られる。
        // j: 2~n-1回まで繰り返す == (2+n-1) * (n-2) / 2 == これが、iとjを合わせた時の試行回数
        // k: 3~n  回まで繰り返す == つまり総計実行回数はjの実行回数*kの実行回数になるよね？
        // じゃ、kの最初と最後の項目の平均 {(3+n) / 2}を{(2+n-1) * (n-2) / 2}/2の分繰り返すの？
        // いや違うだろ。。

        // 頭悪すぎ太郎 n=7
        // iは？ n-2回
        // 1,2,3,4,5
        // jは？ n-2回~iによって減少する
        // 2,3,4,5,6 / 3,4,5,6 / 4,5,6 / 5,6 / 6
        // kは？ n-2回~jによって減少する
        // 3,4,5,6,7 / 4,5,6,7 / 5,6,7 / 6,7 / 7 // 4,5,6,7 / 5,6,7 / 6,7 / 7 // 5,6,7 / 6,7 / 7 // ...
        // i, j, k
        // 1 > 2 > 3,4,5,6,7
        // 1 > 3 > 4,5,6,7
        // 1 > 4 > 5,6,7
        // ..
        // なので、nCrの式 n!/(n-r)!*r!
        // n!/(n-3)!3!
        // n*(n-1)*(n-2)/3*2*1

        // こっちの考えはうまくいかなかった。。
        // もうこれでkの実行回数の視覚化はできたが、
        // nが7だったらkの実行回数はこれらの合計だね
        // 5,4,3,2,1 // 4,3,2,1 // 3,2,1 // 2,1 // 1
        // 各セクションの実行回数合計は等差数列の式{(n-2)+1}*(個数)/2で表せる。。が、、、

        BigInteger minus1 = n.subtract(BigInteger.valueOf(1));
        BigInteger minus2 = n.subtract(BigInteger.valueOf(2));
        BigInteger answer = n.multiply(minus1).multiply(minus2).divide(BigInteger.valueOf(6));
        System.out.println(answer);
        System.out.println(3);
    }
}
