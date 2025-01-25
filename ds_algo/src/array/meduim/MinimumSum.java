package array.meduim;

import java.util.Arrays;

public class MinimumSum {

    public static void main(String[] args) {
        MinimumSum minimumSum = new MinimumSum();
        int[] nums1 = {6, 8, 4, 5, 2, 3};
        int[] nums2 = {5, 3, 0, 7, 4};
        String result = minimumSum.minSum2(nums2);
        System.out.println(result);

    }

    String minSum(int[] arr) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        boolean isOdd = n%2==1? true: false;

        int[] even = new int[n/2];
        int[] odd = new int[n/2];
        int evenIndex = 0;
        int oddIndex = 0;

        if(isOdd){
            even = new int[n/2 + 1];
            odd = new int[n/2];
        }

        for(int i=0;i<n;i++){
            // even
            if(i%2==0){
                even[evenIndex] = arr[i];
                evenIndex++;

            }
            else{
                odd[oddIndex] = arr[i];
                oddIndex++;

            }

        }
       // now sum
        int[] result = new int[even.length > odd.length ? even.length + 1 : odd.length+1];
        int resultIndex = result.length-1;
        evenIndex = even.length-1;
        oddIndex = odd.length-1;
        System.out.println(Arrays.toString(even));
        System.out.println(Arrays.toString(odd));

        int carry = 0;
        while( evenIndex >= 0 || oddIndex >=0 || carry >0 ){
            int a = evenIndex>=0 ? even[evenIndex] : 0;
            int b = oddIndex >= 0 ? odd[oddIndex] : 0;
            int sum = a + b + carry;
            result[resultIndex] = sum%10;
            carry = sum/10;
            evenIndex--;
            oddIndex--;
            resultIndex--;
        }
        int temp =0;
        String resultString = "";
        while(result[temp]==0){
            temp++;
        }
        for(int i=temp;i<result.length;i++){
          resultString += String.valueOf(result[i]);
        }

        System.out.println(Arrays.toString(result));
        System.out.println("finalResult="+resultString);





        return "";


    }
    String minSum2(int[] arr) {
        Arrays.sort(arr);  // Sort the array

        // Strings to build the two numbers
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        // Alternate placing digits in num1 and num2
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }

        // Function to add two numbers represented as strings
        return addStrings(num1.toString(), num2.toString());
    }

    // Helper function to add two numbers represented as strings
    String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';

            result.append(sum % 10);
            carry = sum / 10;
        }

        result.reverse();
        int start = 0;
        while (start < result.length() && result.charAt(start) == '0') {
            start++;
        }
        return result.substring(start);
    }
}
