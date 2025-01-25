package geeksForGeeks;

import java.util.Arrays;

public class SwapAndMaximize {

    public static void main(String[] args) {
        SwapAndMaximize  swapAndMaximize = new SwapAndMaximize();
        Long[] arr = new Long[]{10l,12l};
        swapAndMaximize.maxSum(arr);
    }

    public long maxSum(Long[] arr) {
        // code here
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Long[] temp = new Long[arr.length];

        int start = 0;
        int end = arr.length - 1;
        int index = 0;
        while(start <= end){
            temp[index] = arr[start];
            index++;
            if(index < arr.length) {
                temp[index] = arr[end];
            }
            index++;
            start++;
            end--;
        }


        System.out.println(Arrays.toString(temp));
        long sum = 0l;
        for(int i=0; i<temp.length;i++){
            int nextIndex =  (i + 1)%temp.length;
            sum +=  Math.abs(temp[i]  - temp[nextIndex]);
        }
        System.out.println(sum);
        return 0l;
    }
}
