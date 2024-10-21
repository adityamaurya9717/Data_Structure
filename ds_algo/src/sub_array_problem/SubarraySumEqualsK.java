package sub_array_problem;

import java.util.ArrayList;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3 ,7 ,5};
        int n = arr.length;
        int k = 12;

        ArrayList<Integer> result = subarraySum(arr, n, k);

        System.out.println(result);
    }

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int k) {
        // code here

        int start = 0;
        int end = 0;
        int sum = 0;

        int i = -1;

        int j = -1;
        ArrayList<Integer> result = new ArrayList();


        while(end < n){
            sum+=arr[end];

            while(sum >= k && start<=end){
                if(sum==k){
                    i = start;
                    j = end;
                    result.add(i+1);
                    result.add(j+1);
                    return result;
                }
                sum-=arr[start];
                start++;
            }
            end++;

        }

            result.add(-1);
            return result;

    }
}
