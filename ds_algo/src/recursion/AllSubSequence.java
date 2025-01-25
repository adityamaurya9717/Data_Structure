package recursion;

import java.util.Arrays;

public class AllSubSequence {

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        AllSubSequence seq = new AllSubSequence();
        seq.allSubsequence(arr, 0,"");
    }

    private void allSubsequence(int[] arr, int i,String s) {
        if(i>arr.length) return;
        System.out.println(s);
        for(int j=i;j<arr.length;j++){
            allSubsequence(arr, j+1, s+arr[j]);
        }

    }


}
