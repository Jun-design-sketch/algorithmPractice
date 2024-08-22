package basicMathematics.beeHive2292;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
//        solution.sol1();
        solution.sol2();
    }
}

class Solution {
    protected void sol2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int count = 1; // 移動距離
        int increase = 6; // 増加幅
        int num = 1;
        // 1 7 19 37 61
        //  6 12 18 24
        // 停止条件： n <= num
        while (n > num){
            // numにincreaseを足して、その後increaseの条件を調整すれば簡単だった
            // increaseが乗数倍で増える訳ではないので演算も単純であった
            // 前回のwhileで、num(前回) < nは満たしていて、今回のwhileで n <= num(今回)であれば
            // while文が終了する。結果、sol1のwhile条件と変わりなく実行できる。
            num += increase;
            increase += 6; // 6, 12, 18, 24..
            count++;
        }
        bw.write(""+count);
        bw.flush();
        bw.close();
    }
    protected void sol1() throws IOException{
        // 蜂の巣は六角形。
        // 六角形と言えど、一回り回れば外側から真ん中までの移動距離は等しい。(常に１を基準に回転するから）
        // i周目とi+1週目の間確認
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int answer = 0;
        int spin = 0;
        if(n > 7){
            // i-1周の巣の数　<= n < i周の巣の数
            Convert conv = new Convert();
            int minHouseCount = conv.houseCount(spin);
            int maxHouseCount = conv.houseCount(spin + 1);
            // finish condition: minHouseCount < n && n <= maxHouseCount
            while (minHouseCount >= n || n > maxHouseCount) {
                spin++;
                minHouseCount = conv.houseCount(spin);
                maxHouseCount = conv.houseCount(spin + 1);
            }
            answer = spin + 2;
        }else if(n > 1){
            answer = 2;
        }else{
            answer = 1;
        }
        bw.write("" + answer);
        bw.flush();
        bw.close();
    }
}

class Convert {
    // 1 7 19 37 61
    //  6 12 18 24
    // n=0 -> 1+(0*6)
    // n=1 -> 1+(1*6)
    // n=2 -> 1+(1*6)+(2*6)
    // n=3 -> 1+(1*6)+(2*6)+(3*6)
    protected int houseCount(int spin){
        int coefficient = 0;
        for(int i=0; i<=spin; i++){
            coefficient += i;
        }
        int houseExceptOne = 1+(coefficient*6);
        return houseExceptOne;
    }
}
