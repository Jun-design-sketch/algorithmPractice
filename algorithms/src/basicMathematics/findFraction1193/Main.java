package basicMathematics.findFraction1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        br.close();
        // 1/1
        // 1/2 2/1
        // 3/1 2/2 1/3
        // 1/4 2/3 3/2 4/1
        // 5/1 4/2 3/3 2/4 1/5
        // 1/6 2/5 3/4 4/3 5/2 6/1
        // 分数を探す問題と書いてあるが、実際は合計2から合計が１づつ増加していくパターンになる
        int sum = 2;
        int floor = 1;
        int accumulation = 1;
        int increase = 1;
        while (x > accumulation){
            sum++;
            floor++;
            increase++;
            accumulation += increase;
        }
        int floorPositionReverse = accumulation - x + 1;
        int numerator = floor % 2 == 0 ? sum - floorPositionReverse : floorPositionReverse;
        int denominator = sum - numerator;
        System.out.printf("%d/%d", numerator, denominator);
    }
}
