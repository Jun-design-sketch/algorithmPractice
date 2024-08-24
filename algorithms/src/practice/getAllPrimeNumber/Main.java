package practice.getAllPrimeNumber;

public class Main {
    public static void main(String[] args) {
        int N = 45;
        PrimeNumber prime = new PrimeNumber();
        // prime.get1(N);
        // prime.get2(N);
        prime.get3(N);
    }
}

class PrimeNumber {
    // do all one by one
    protected void get1(int N) {
        int x,y,flg;
        for(x=1; x<=N; x++){

            if(x==1 || x==0) continue; // 1と0は素数ではないから要らん

            flg = 1;
            for(y=2; y<=x/2; ++y){ // 約数とは？「割り算できる」もの。整数の最小値は「２」
                // ここの++yは、y++でも同じ。
                // pre-incrementかpost-incrementかの違いはあるものの。。
                // C++ではどっちも使える場合++yを使う方が望ましいらしい。
                // というのも、y++は（値を増加させる）（増加されていない値return）という２つの値を保管しなきゃならんから
                if(x%y==0){
                    flg = 0;
                    break;
                }
            }

            if(flg == 1) System.out.print(x+" ");
        }
    }

    // square-root
    protected void get2(int N) {
        int x,y,flg;
        for(x=2; x<=N; x++){
            flg=1;
            for(y=2; y*y<=x; y++){ // ^2の数字のみ検査で素数を洗い出すことができる
                // 約数の対
                // とある整数AがBという約数を持つなら、他の約数Cは必ずA/Bになる。
                // A = B*C
                // 約数が等しい場合は(√A)の１ケースのみ
                // したがって、整数A(が素数でない場合)、約数２つのうち１つは必ず√A以下の命題成立
                if(x%y==0){ // xがyで割られるならxは素数じゃないよな
                    flg=0;
                    break;
                }
            }
            if(flg==1) System.out.print(x+" ");
        }
    }

    // Sieve of Eratosthenes
    protected void get3(int N) {
        boolean[] prime = new boolean[N+1];
        // Sieve(フィルター)作り
        for(int i=0; i<=N; i++){
            prime[i]=true;
        }
        // 配列に原理にしたがってFALSEをつける
        for(int j=2; j*j<=N; j++){ // 約数対のうち１つは必ず√N以下だから
            if(prime[j]){
                for(int k=j*j; k<=N; k+=j){ // j*jより少ない素数の倍数は、現在のjより少ない素数により処理されるため
                    // 素数自体はTRUEで、素数の倍数をFALSE付け
                    prime[k]=false;
                }
            }
        }
        // OUTPUT
        for(int i=2; i<=N; i++){
            if(prime[i]) System.out.print(i+" ");
        }
    }
}
