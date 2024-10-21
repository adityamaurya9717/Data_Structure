package array.meduim;

import java.util.Arrays;

public class NearestMultipleOf10 {

    public static void main(String[] args) {
        NearestMultipleOf10 nearestMultipleOf10 = new NearestMultipleOf10();
        System.out.println(nearestMultipleOf10.roundToNearest("29"));

    }

    String roundToNearest(String str) {

        int n = str.length()-1;

        char[] arr = str.toCharArray();

        if(arr[n] <= '5'){
            arr[n]  = '0';
            return new String(arr);
        }
        arr[n] = '0';
        n = n-1;

        while(n>=0 && arr[n]=='9'){
            arr[n] = '0';
            n--;

        }
        System.out.println(Arrays.toString(arr));
        if(n==-1){
            return "1" + new String(arr);
        }
        else{
            arr[n]+=1;
            return new String(arr);
        }


    }
}
