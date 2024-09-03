package bruteForce.sugar2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 砂糖配達において、袋の数を最小に抑えられるケースを求め、その時の袋の数を出力する
    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.sol1();
    }
}

class Test {
    public static int KILOGRAM_5 = 5;
    public static int KILOGRAM_3 = 3;
    // bruteForce以外の解き方：パターン毎に取得

    // bruteForce
    protected void sol1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int max5 = n/KILOGRAM_5;
        int max3 = n/KILOGRAM_3;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<=max5; i++){
            for(int j=0; j<=max3; j++){
                if(i*5+j*3==n){
                    min = (i+j) < min ? (i+j) : min;
                }
            }
        }
        if(min==Integer.MAX_VALUE) min=-1;
        System.out.println(min);
    }

}