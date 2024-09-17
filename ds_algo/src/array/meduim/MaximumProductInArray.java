package array.meduim;

/**
 * 154 ) Maximum Product Subarray
 */
public class MaximumProductInArray {

    public static void main(String[] args) {
        MaximumProductInArray maximumProductInArray = new MaximumProductInArray();
        int arr[] = {9,5,6,7,-2,1,2,2,3};
        System.out.println(maximumProductInArray.getMaxProduct(arr));
    }

    private int getMaxProduct(int[] arr) {
        int result = 1;

        int leftProduct = 1;
        int rightProduct = 1;


        for(int i = 0; i < arr.length; i++) {

            if(leftProduct==0) leftProduct =1;
            if(rightProduct==0) rightProduct =1;

            leftProduct = leftProduct * arr[i];
            rightProduct = rightProduct * arr[arr.length - i-1];

            result = Math.max( result , Math.max(leftProduct,rightProduct));
        }



        return result;
    }
}
