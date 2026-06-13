package leet.leet0238;

import java.util.Arrays;

// memoization
// 累積の場合、どの段階までの状態が必要か
// prefix suffix
// 解を求めるためまずは分解する
// ロジックができてから、省略可能な時間・空間を考える
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums1 = {1,2,3,4};
        System.out.println(Arrays.toString(main.productExceptSelfImproved2(nums1))); // 24,12,8,6

        int[] nums2 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(main.productExceptSelfImproved2(nums2))); // 0,0,9,0,0
    }

    // 初回作成
    // 前回までの計算結果を再利用する。
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

    public int[] productExceptSelfImproved(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i=1; i<left.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        int[] answer = new int[nums.length];
        answer[nums.length-1] = 1;
        for(int j=answer.length-2; j>=0; j--) {
            answer[j] = answer[j+1] * nums[j+1];
        }

        for(int k=0; k<nums.length; k++) {
            answer[k] *= left[k];
        }

        return answer;
    }

    // 右側の累積積はintで管理する
    public int[] productExceptSelfImproved2(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for(int i=1; i<answer.length; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        int right = 1;
        for(int j=answer.length-2; j>=0; j--) {
            right *= nums[j+1];
            answer[j] *= right;
        }

        return answer;
    }
}
