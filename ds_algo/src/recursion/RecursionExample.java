package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionExample {

   public static int count = 0;
    public static void main(String[] args) {
        targetSum();
    }



    /**
     * FIBONNACI NUMBER
     * 1 1 2 3 5 8 13 21 34
     * @param i
     * @return
     */
    private static int fibonacci(int i) {
        if(i==0){
            return 0;
        }
        if(i==1 || i==2){
            return 1;
        }
        return fibonacci(i-1) + fibonacci(i-2);
    }

    public static void targetSum() {
        int[] nums = {
                     3, 6, 2, 3, 4, 7
             };
        int targetSum = 9;
        boolean result = countTargetSum(nums,0,0,targetSum);
        System.out.println("targetSum Present "+result);
        System.out.println(count);
    }


    public static boolean targetSum(int[] arr,int index ,int curentSum,int targetSum) {

      if(targetSum==curentSum){
          return true;
      }
     if(curentSum > targetSum){
            return false;
     }
      if(index >= arr.length){
          return false;
      }
      return targetSum(arr,index+1,curentSum+arr[index],targetSum) || targetSum(arr,index+1,curentSum,targetSum);

    }

    /**
     * how many count sum we make from the array
     * @param arr
     * @param index
     * @param curentSum
     * @param targetSum
     * @return
     */
//    public static boolean countTargetSum(int[] arr,int index ,int curentSum,int targetSum) {
//
//        if(targetSum==curentSum){
//
//           count++;
//            return true;
//        }
//        if(curentSum > targetSum){
//            return false;
//        }
//        if(index >= arr.length){
//            return false;
//        }
//        return countTargetSum(arr,index+1,curentSum+arr[index],targetSum) || countTargetSum(arr,index+1,curentSum,targetSum);
//
//    }

    public static boolean countTargetSum(int[] arr, int index, int currentSum, int targetSum) {
        // Base case: if current sum equals target sum
        if (currentSum == targetSum) {
            count++;
            return true;
        }

        // Base case: if current sum exceeds target sum
        if (currentSum > targetSum) {
            return false;
        }

        // Base case: if index is out of bounds
        if (index >= arr.length) {
            return false;
        }

        // Recursive case: include or exclude the current element
        boolean include = countTargetSum(arr, index + 1, currentSum + arr[index], targetSum);
        boolean exclude = countTargetSum(arr, index + 1, currentSum, targetSum);

        return include || exclude;
    }



}
