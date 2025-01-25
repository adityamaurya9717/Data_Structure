package hackerRank;

import java.util.Arrays;

public class BiggerIsGreater {

    public static void main(String[] args) {
        BiggerIsGreater isGreater = new BiggerIsGreater();
        String word = "bb";
        String result = nextGreaterWord(word);
        System.out.println(result);


    }
    public static String nextGreaterWord(String word) {
        char[] chars = word.toCharArray();
        int n = chars.length;

        int i = n-2;
        while(i >=0){
            if(chars[i] < chars[i+1]){
                break;
            }
            i--;
        }

        if( i < 0){
            return "No Answer";
        }
        // finding next Greatest Word
        nextGreatesIndex(chars,i);
        reverse(chars,i+1);
        return new String(chars);


    }
    public static void nextGreatesIndex(char[] arr,int i){
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
    private static void reverse(char arr[], int i){

        int end = arr.length-1;
        int start = i;
        while(start < end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    public static void swap(char arr[], int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Utility method to swap two characters in an array

}
