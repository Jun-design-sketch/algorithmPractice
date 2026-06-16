package leet.leet0334;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums1 = {1,2,3,4,5};
        System.out.println(main.increasingTriplet(nums1)); // true

        int[] nums2 = {5,4,3,2,1};
        System.out.println(main.increasingTriplet(nums2)); // false

        int[] nums3 = {2,1,5,0,4,6};
        System.out.println(main.increasingTriplet(nums3)); // true
    }

    // 返却すべきものは何か？存在有無のみでインデックス不要
    // 条件を成立する瞬間があり、その瞬間が解の条件に等しいならtrueを返却して良い
    // 問題を見た時の初印象と、実際に必要であるものは異なるかもしれない
    public boolean increasingTriplet(int[] nums) {
        // 全ての位置を知る必要はない
        int smallest = Integer.MAX_VALUE;
        int next = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            // 任意の要素Aが最初smallestに入る
            if(nums[i] <= smallest) smallest = nums[i];
            // 任意の要素Aより大きい、任意の要素Bがnextに入る
            else if(nums[i] <= next) next = nums[i];
            // 任意の要素Aより大きく、任意の要素Bよりも大きい要素Cが有ればTRUEになる
            else return true;
        }
        return false;
    }

    //        Map<Integer, Integer> map = new TreeMap<>();
    //        for(int i=0; i<nums.length; i++) {
    //            map.put(nums[i], i);
    //        }
}
