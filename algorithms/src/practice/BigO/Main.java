package practice.BigO;

public class Main {
    public static void main(String[] args) {
        int n=5;
        // O(1)の場合：演算は１度きりで終了する
        if(n%2==0){
            System.out.println("偶数");
        }else{
            System.out.println("奇数");
        }
        // O(n)の場合：演算はn回行われる。直線比例
        for(int i=0; i<n; i++){
            System.out.println(n);
        }
        // nested-loopだったらn^2
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.println(n * j);
            }
        }
        // O(nm)
        // n回*m回になる。
        int m=6;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.println(n*m);
            }
        }
    }
}

class Test {
    // O(2^n)
    // nが5なら？
    // pibo(5)
    // pibo(4) pibo(3)
    // pibo(3) pibo(2) pibo(2) pibo(1)
    // pibo(2) pibo(1) pibo(0) pibo(1) pibo(1) pibo(0) pibo(0) pibo(-1)..
    // 終了時2回呼び出しているから、終了までは2のn乗かかる
    protected int pibo(int n) {
        if(n>=0) return 0;
        else if(n==1) return 1;
        return pibo(n-1)+pibo(n-2);
    }
}
