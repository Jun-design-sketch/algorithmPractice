package leet.leet1431;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int [] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        System.out.println(main.kidsWithCandies(candies, extraCandies));

        int [] candies2 = {4, 2, 1, 1, 2};
        int extraCandies2 = 1;
        System.out.println(main.kidsWithCandies(candies2, extraCandies2));

        int [] candies3 = {12, 1, 12};
        int extraCandies3 = 10;
        System.out.println(main.kidsWithCandies(candies3, extraCandies3));
    }

    // 配列の最大値が存在するかを確認できれば良い。
    // TreeSetは適切ではない
    // 重複値を処理できない
    // Treeに挿入する費用 O(log n) * n回 O(n) = O(n log n)
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 単純巡回する
        int max = Integer.MIN_VALUE;
        for(int candy : candies) {
            max = Math.max(max, candy);
        }

        // 2回目巡回だけれど、定数は省かれるので全体としてO(n)
        // nの増加に伴う計算量の増加幅を数えるものであるため
        List<Boolean> li = new ArrayList<>();
        for(int candy : candies) {
            int receiveExtra = candy + extraCandies;
            Boolean check = receiveExtra >= max;
            li.add(check);
        }

        return li;
    }
}