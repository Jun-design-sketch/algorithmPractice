package leet.leet0001;

import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] q1 = main.betterTwoSum(new int[]{2,7,11,15}, 9);
        System.out.println(q1[0] + " " + q1[1]);

        int[] q2 = main.betterTwoSum(new int[]{3,2,4}, 6);
        System.out.println(q2[0] + " " + q2[1]);

        int[] q3 = main.betterTwoSum(new int[]{3,3}, 6);
        System.out.println(q3[0] + " " + q3[1]);
    }
    /*
    * 時間とメモリ消費のトレードオフ
    * HashMapのキーは巡回不要
    * 回答が必ず対であるため、巡回の回数を減らせる
    * デフォルト値の意味が誤解を招かないように
     */
    public int[] betterTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // 一度の巡回：O(n)
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            // containsValue()は巡回する。一方、containKey()は巡回しない
            // よって値をKEY, INDEXをVALUEにする
            map.put(nums[i], i);
        }

        return new int[] {};
    }

    public int[] twoSum(int[] nums, int target) {
        // HashMapにする
        // contains()系のメソッドを使いたいため
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        // 値初期化：回答がない場合も0,0になるのはよくない
        int a = 0;
        int b = 0;
        // 順次確認
        for(int i = 0; i < nums.length; i++) {
            // 必要とする対
            int check = target - map.get(i);
            // ここで既に要素iは利用済みであるため、除外
            map.remove(i);
            // 対が存在する場合
            if (map.containsValue(check)) {
                a = i;
                // 対の位置を確定：ここで、O(n^2)に近い
                for (int j = 0; j < nums.length; j++) {
                    if (map.get(j) != null && map.get(j) == check) {
                        b = j;
                        break;
                    }
                }
                break;
            // 対が存在しない場合
            } else {
                map.put(i, nums[i]);
            }
        }
        int[] answer = {a, b};
        return answer;
    }
}
