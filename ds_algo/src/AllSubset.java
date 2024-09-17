import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubset {

    static List<List<Integer>> result = new ArrayList();

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(19,10,12,10,24,25,22);
        maxSubset(nums);

    }

    public static void maxSubset(List<Integer> nums) {
        int k = 4;

        int fre[] = new int[k];
        for(int i = 0; i < nums.size(); i++){
            fre[nums.get(i)%k]++;
        }
        System.out.println(Arrays.toString(fre));

    }

    /**
     *   [19] , [10] [19,10] , [12] [19 ,12] [19 ]
     * @param list
     */
    public static void allSubset(List<Integer> nums){

        if(nums.isEmpty()){
            System.out.println("Empty List");
            return;
        }
        List<List<Integer>> subsets = new ArrayList<>();

        for(int i = 0; i < nums.size(); i++){
            //current Element
            int n = subsets.size();
            for (int j=0;j<n;j++){
                List<Integer> temp = new ArrayList<>(subsets.get(j));
                temp.add(nums.get(i));
                subsets.add(temp);
            }
            subsets.add(Arrays.asList(nums.get(i)));

        }
        System.out.println(subsets.size());
    }

    public static void allSubsetRecursion(int nums[],List<Integer> temp,int i){
        result.add(new ArrayList<>(temp));
        for (int k = i; k < nums.length; k++){
            temp.add(nums[k]);
            allSubsetRecursion(nums,temp,k+1);
            temp.remove(temp.size()-1);
        }
    }
}
