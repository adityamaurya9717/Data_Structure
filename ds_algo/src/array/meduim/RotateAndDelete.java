package array.meduim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateAndDelete {

    public static void main(String[] args) {
        RotateAndDelete rotateAndDelete = new RotateAndDelete();
        int[] nums = {1,2,3,4,5,6};
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int num : nums) {
            arrList.add(num);  // Add each element to the ArrayList
        }
        int res=rotateDelete(arrList);
        System.out.println(res);

    }

    public static int rotateDelete(ArrayList<Integer> arr) {
        // code here

        int sz = arr.size()/2;

        for(int k=1;k<=sz;k++){


            int lastElement = arr.get(arr.size() - 1);

            arr.add(0, lastElement);
            arr.remove(arr.size()-1);

            int deleteIndex = arr.size() - k;
            arr.remove(deleteIndex);
        }

        return arr.get(0);


    }

}
