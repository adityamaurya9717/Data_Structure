package array.meduim;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int []arr = {2,3,1,3,3};
        NextPermutation p = new NextPermutation();
         p.nextPermutation(arr);
    }

    private void nextPermutation(int[] arr) {

        int n = arr.length;
        int i = n -2;

        while( i >=0){
            if(arr[i] < arr[i+1]){
                break;
            }
            i--;
        }
        if(i < 0){
            System.out.println("not greates found");
            return;
        }
        System.out.println(i);
        nextGreatesIndex(arr,i);
        reverse(arr,i+1);
        System.out.println(Arrays.toString(arr));

    }

    public void nextGreatesIndex(int[] arr,int i){
        int index = i+1;
        int max = arr[index];
        for(int j=i+1;j<arr.length;j++){
            if(arr[j] > arr[i] && arr[j] <= max){
                max = arr[j];
                index = j;
            }
        }
        swap(arr,i,index);
    }

    private void reverse(int arr[],int i){

        int end = arr.length-1;
        int start = i;
        while(start < end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    public void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
