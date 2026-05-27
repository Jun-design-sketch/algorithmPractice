package leet.leet0219;

import java.util.HashMap;

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
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
