package leet.leet0238;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums1 = {1,2,3,4};
        System.out.println(Arrays.toString(main.productExceptSelf(nums1))); // 24,12,8,6

        int[] nums2 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(main.productExceptSelf(nums2))); // 0,0,9,0,0
    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(i == 0) left[i] = 1;
            else left[i] = left[i-1] * nums[i-1];
        }

        int[] right = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--) {
            if(i == nums.length-1) right[i] = 1;
            else right[i] = right[i+1] * nums[i+1];
        }

        int[] answers = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            answers[i] = left[i] * right[i];
        }

        return answers;
    }
}
