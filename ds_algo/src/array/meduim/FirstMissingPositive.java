package array.meduim;

public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        boolean contains1 = false;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                contains1 = true;
            }
            if(nums[i] <=0 || nums[i]>n ){
                nums[i] = 1;
            }

        }

        if(!contains1){
            return 1;
        }

        for(int i=0;i<n;i++){
            int num = Math.abs(nums[i]);
            int index = num-1;

            if(nums[index] < 0 ) continue;

            nums[index] = -1 * nums[index];
        }

        for(int i=0;i<n;i++){
            if(nums[i] > 0) {
                return i+1;
            }
        }
        return n+1;

    }
}
