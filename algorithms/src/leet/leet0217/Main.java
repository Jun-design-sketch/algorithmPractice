package leet.leet0217;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int[] q1 = {1,2,3,1};
        System.out.println(main.containsDuplicate(q1));
        System.out.println(main.containsDuplicateSet(q1));

        int[] q2 = {1,2,3,4};
        System.out.println(main.containsDuplicate(q2));
        System.out.println(main.containsDuplicateSet(q2));

        int[] q3 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(main.containsDuplicate(q3));
        System.out.println(main.containsDuplicateSet(q3));
    }

    public boolean containsDuplicate(int[] nums) {
        boolean answer = false;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])){
                answer = true;
                break;
            }
            map.put(nums[i], i);
        }

        return answer;
    }

    /*
    * HashSet
    * This class offers constant time performance for the basic operations (add, remove, contains and size),
    * assuming the hash function disperses the elements properly among the buckets.
    * 線形的な性能、ただしバケットにいい感じに割り振られていれば
     */
    // 0217はindex不要の、「前見たことあるか」で事足りるためHashSetの方がより望ましい。
    public boolean containsDuplicateSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
