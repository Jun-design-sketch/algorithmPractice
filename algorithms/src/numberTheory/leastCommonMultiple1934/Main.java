package numberTheory.leastCommonMultiple1934;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // LCMを求める：GCDから簡単に出せるか？
    // 例えば：6と15のLCMを考える
    // 6<>15のGCDは3. LCMは30. == 2*3*5
    // 9<>12のGCDは3. LCMは36. == 2*2*3*3
    // 学校で習った公約数の求め方は、AとBを全部因数分解してから共通したものを掛け算する方法だが

    // まずは、GCDを求めるのだが
    // ユークリッド互除法を使える（使って）と言っている問題だそうだ
    // a>=bにおいて、a/b = rとする。（自然と0<=r<bだ）
    // この時GCD(a,b) = GCD(b,r)が成立する

    // なぜか？
    // A>=Bにおいて、A/B = rであり、GCD(A,B) = dとすれば
    // 1. A = Bq + rと書ける。（qの値は不明だが）
    // 2. また、GCDがdなのでA = ad, B = bdになる
    // 3. A = Bq + rからr = A - Bqとなる
    // 4. 2と3から、r = ad - bdqとなる
    // r = d(a-bq)
    // ここで、B = bdなので rとBにおいてdが共通の約数だ。(dがGCDかは不明）

    // bdとa-bqが互いに素であるかを確認する：互いに素でないと仮定して矛盾があることを証明する。（背理法）
    // 互いに素でなけりゃ、公約数がある。
    // b, (a-bq)の公約数をpとする。
    // b = mp, (a-bq) = npとする
    // (a-bq)=npにb=mpを代入する。
    // a-mpq=np
    // a=mpq+np, a=p(mq+n). bはmpだ。
    // じゃ、aとbはpを公約数に持つ。-> 仮定の矛盾発見

    // なので、bdとa-bqは互いに素でありdも最大公約数であることが間違いない。

    // じゃ、どうしてGCDとLCMは関連性があるんだ？という話になる
    // A = ad, B = bdに戻ってdがGCDであった。
    // なのであれば、最小公倍数は当たり前なことにa*b*dになる。だって
    // A * b = B * a = a*b*dだから。。。
    // そしてユークリッド互除法によりdは簡単に求められる
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[2];
            for(int j=0; j<2; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int a = arr[1];
            int b = arr[0];
            int ab = a*b;

            // GCD
            while(b != 0){
                int r = a % b;
                a = b;
                b = r;
            }
            // A = ad, B = bd, AB = abdd, LCM = AB/d
            sb.append(ab/a+"\n");
        }
        br.close();
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
