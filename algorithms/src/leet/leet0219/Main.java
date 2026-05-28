package leet.leet0219;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] q1 = {1,2,3,1};
        int k1 = 3;
        System.out.println(main.containsNearbyDuplicate(q1, k1));

        int[] q2 = {1,0,1,1};
        int k2 = 1;
        System.out.println(main.containsNearbyDuplicate(q2, k2));

        int[] q3 = {1,2,3,1,2,3};
        int k3 = 2;
        System.out.println(main.containsNearbyDuplicate(q3, k3));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // 具現体のHashMapより、抽象タイプMapで扱う方が望ましい
        // 具現体の特徴が必須なら使ってもよいが、型変換や汎用性で見てMap機能のみなら左辺はMapの方が柔軟
        // （左）何ができるか = （右）具体的にどうするか
        Map<Integer, Integer> map = new HashMap<>();

        // O(n)
        for(int i = 0; i < nums.length; i++) {
            // O(1)
            if(map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) return true;
            // この問題では測定済みかつここに辿りづいた時点で再度更新してOKになる
            map.put(nums[i], i);
        }
        return false;
        // 全ての要素がMAPに独立して入ると空間複雑度はO(n)
    }
}
