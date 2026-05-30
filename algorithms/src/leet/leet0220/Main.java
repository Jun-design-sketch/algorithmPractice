package leet.leet0220;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int[] nums1 = {1,2,3,1};
        int indexDiff1 = 3;
        int valueDiff1 = 0;
        System.out.println(main.containsNearbyAlmostDuplicate(nums1, indexDiff1, valueDiff1));

        int[] nums2 = {1,5,9,1,5,9};
        int indexDiff2 = 2;
        int valueDiff2 = 3;
        System.out.println(main.containsNearbyAlmostDuplicate(nums2, indexDiff2, valueDiff2));

        int[] nums3 = {1,0,1,1};
        int indexDiff3 = 1;
        int valueDiff3 = 2;
        System.out.println(main.containsNearbyAlmostDuplicate(nums3, indexDiff3, valueDiff3));

        int[] nums4 = {8,7,15,1,6,1,9,15};
        int indexDiff4 = 1;
        int valueDiff4 = 3;
        System.out.println(main.containsNearbyAlmostDuplicate(nums4, indexDiff4, valueDiff4));
    }
    // HashMapで解こうとして大変な目に会った
    // 要件に合致した資料構造であればあるほど簡単に解ける

    // indexDiff分の要素の大小関係：整列
    // nums[i]よりvalueDiff分の大小関係にあるものを洗い出す：ceiling()
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for(int i=0; i<nums.length; i++) {
            long current = nums[i];
            Long candidate = set.ceiling(current - valueDiff);

            if (candidate != null && candidate <= current + valueDiff) {
                return true;
            }

            set.add((long) nums[i]);
            if(set.size() > indexDiff) set.remove((long) nums[i - indexDiff]);
        }
        return false;
    }
}
