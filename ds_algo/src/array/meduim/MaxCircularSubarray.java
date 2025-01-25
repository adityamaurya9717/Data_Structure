package array.meduim;

import java.util.Arrays;

public class MaxCircularSubarray {

    public static void main(String[] args) {
        MaxCircularSubarray maxCircularSubarray = new MaxCircularSubarray();
        int[] nums = {1,-2,3,-2};
        System.out.println(maxCircularSubarray.maxSubarraySumTwo(nums));
    }

    private int maxSubarraySum(int[] nums) {
        int result = 0;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int prefixMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefixMax = Math.max(prefixMax,nums[i] + prefix[i-1]);
            prefix[i] = prefixMax;
        }

        System.out.println(Arrays.toString(prefix));
       int[] suffix = new int[nums.length];
       suffix[nums.length-1] = nums[nums.length-1];

       for(int i=nums.length-2;i>=0;i--){
           suffix[i] = nums[i] + suffix[i+1];
       }
        System.out.println(Arrays.toString(suffix));
        return result;
    }

    private int maxSubarraySumTwo(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        rightMax[n-1] = nums[n-1];
        int suffix = nums[n-1];

        for(int i=n-2;i>=0;i--){
            suffix = suffix + nums[i];
            rightMax[i] = Math.max(rightMax[i+1],suffix);
        }
        System.out.println(Arrays.toString(rightMax));

        int[] prefix = new int[n];
        prefix[0] = nums[0];
        int currSum = 0;
        int maxSum = 0;
        int specialSum = nums[0];

        for(int i=0;i<n;i++){
            currSum +=nums[i];
            if(nums[i] > 0){
                currSum = nums[i];
            }
            maxSum = Math.max(maxSum, currSum);
            if(i>0) {
                prefix[i] = prefix[i - 1] + nums[i];
            }
            if(i+1<n){
                specialSum = Math.max(specialSum, prefix[i] + rightMax[i+1]);
            }

        }
        System.out.println(Arrays.toString(prefix));


        return Math.max(specialSum,maxSum);
    }
}
