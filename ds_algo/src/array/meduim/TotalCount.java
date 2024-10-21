package array.meduim;

import java.util.ArrayList;

public class TotalCount {

    public static void main(String[] args) {
        int[] nums = {10, 2, 3, 4, 7};
        int target = 4;
        int count = totalCount(nums, target);
        System.out.println("Count: " + count);
        ArrayList<Integer> counts = new ArrayList<Integer>();
    }

    private static int totalCount(int[] arr, int k) {

        int count = 0;

        for(int i=0;i<arr.length;i++){

            if(arr[i]%k==0){
                count+=arr[i]/k;
            }
            else{
                count += arr[i]/k +1;
            }


        }

        return count;
    }
}
