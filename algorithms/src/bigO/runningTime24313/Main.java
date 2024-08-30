package bigO.runningTime24313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // O(g(n)) = {f(n) | 모든 n ≥ n0에 대하여 f(n) ≤ c × g(n)인 양의 상수 c와 n0가 존재한다}
        // g(n)といった関数がBigO, O()だとする。
        // O(g(n)) = {f(n) |「全てのn>=n0に対して、f(n)<=c*g(n)である自然数cとn0が存在する」}
        // f(n) = a1n+a0.

        // O(g(n))集合は関数f(n)たちが含まれている集合である。

        // g(n)とはなんでいきなり出てきたか？
        // 「全てのn>=n0に対して、f(n)<=c*g(n)である自然数cとn0が存在する」
        // これは、f(n)とg(n)の関係を示している。
        // f(n) > c*g(n)だったら？
        // それぞれ同じ変数を受け取っていても、f(n)はg(n)より大きくなり得ることを意味する。
        // じゃ、f(n) <= c*g(n)というのは？
        // それぞれ同じ変数を受け取っていても、f(n)はg(n)より大きくなり得ないことを意味する。
        // ただでそうなれとは言わない、n0でnの最小値がセットされ、定数cがある場合の話だ　-> この問題の内容でもある

        // 本題に戻り、O(g(n))は時間複雑度を指している。
        // (g(n))とは、結局はf(n)の時間複雑度を求めるためにあるからそれこそ時と場合による。
        // 適切なg(n)を選定する
        // 通常の時間複雑度は指数関数の逆関数だ。f(n)が二乗だったらg(n)はn^2とかにするのだ。O(n^2)だから
        // f(n)はa1*n+a0だから、１次関数だ。線形の成長曲線を描く
        // g(n)も定数倍で成長するものが相応しい。g(n)=nだ

        // g(n)が2nでも3nでもよくないかって？
        // どうせO(3n)もO(2n)もO(n)も、時間複雑度では定数の倍数とかは無視されるから、全部O(n)と同じだ。
        // 考えてみれば定数倍を1回掛け算するのって、定数が何であれ演算回数自体は変わらないから。。
        // 定数がめちゃくちゃ大きくなれば？多分それが空間複雑度なのでは
        // 結論：g(n)=nで良い

        // g(n)を何にするかが決まったら、コードがやっと書ける。。。
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // a1, a0の絶対値は100以下。
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        // 1<=c<=100, 1<=n0<=100
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        int answer;
        // f(n) = a1*n + a0
        // g(n) = n
        // a0が-の時のため、１次項の係数比較を追加
        if(a1*n0+a0 <= c*n0 && a1 <= c){
            answer = 1;
        }else{
            answer = 0;
        }
        System.out.println(answer);
    }
}
