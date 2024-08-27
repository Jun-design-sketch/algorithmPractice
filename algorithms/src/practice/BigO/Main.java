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

        // 定数項を無視
        // O(1)+O(n) = O(n+1)?(X)
        // = O(n)
        if(n%2 == 0){
            System.out.println("偶数");
        }else{
            System.out.println("奇数");
        }
        for(int i=0; i<n; i++){
            System.out.println(n);
        }

        // 同じく、2nではなくO(n)なのだ
        for(int i=0; i<n; i++){
            System.out.println(n);
        }
        for(int i=0; i<n; i++){
            System.out.println(n);
        }

        // コーディングの際にこれを考えつつできていたらいいのだけれど。。
        // 実務ではそんなに効率の良いコードでなくても採用されているか、既に既存コードに入ってる場合も多いから…
        // （BigOが少なくなる==直感的にみんなが分かりやすいコード）ではなさそうな感じ
        // 時間をおいて実装する、性能が大事な一部機能においては極めて有効そうと思う
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

    // バイナリー検索だと半分づつ分けるからこれだとOlog(n)になる
    // 対数関数（ログ関数）は指数関数の逆関数だから、指数を求めるのがlogなのだ
    protected int binarySearch(int[] num, int target, int low, int high) {
        int mid = (low + high) / 2;
        if(target == num[mid]) return mid;
        else if(target < num[mid]) return binarySearch(num, target, low, mid-1);
        else return binarySearch(num, target, mid+1, high);
    }
}
