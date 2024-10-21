package array.meduim;

public class PairSum {

    public static void main(String[] args) {
        PairSum pairSum = new PairSum();
        int arr[] = {9 ,2, 3, 2, 5, 2, 8};
        int result = pairSum.pairWithMaxSumT(arr);
        System.out.println(result);

    }

    public int pairWithMaxSumT(int[] arr) {
        // code here
        int result = -1;
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            //result=-1;
            if(i==3){
                System.out.println("dsd");
            }
            int min = arr[i] < arr[i+1] ?arr[i]:arr[i+1];
            int secondMin = arr[i] > arr[i+1] ?arr[i]:arr[i+1];

            for(int j=i+1;j<n;j++){
                if(arr[j]< min){
                    secondMin = min;
                    min = arr[j];
                }
                else if(arr[j]< secondMin && arr[j]!=min){
                    secondMin = arr[j];
                }

                //int pairSum = min+secondMin;
                //result = Math.max(result,pairSum);
            }
            int pairSum = min+secondMin;
            result = Math.max(result,pairSum);
        }



        return result;
    }

    public int pairWithMaxSum(int[] arr) {
        // code here
        int result = -1;
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            result = Math.max(result,arr[i]+arr[i+1]);
        }



        return result;
    }
}
