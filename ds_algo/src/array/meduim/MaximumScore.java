package array.meduim;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumScore {

    public static void main(String[] args) {
        MaximumScore maximumScore = new MaximumScore();
        int[] nums = {1,10,3,3,3};
        int k = 3;
        System.out.println(maximumScore.maxKelements(nums, k));
    }

    public long maxKelements(int[] nums, int k) {

       // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));


        for(int n : nums){
            pq.add(n);
        }
        long result = 0;
        long score = 0l;
        int i=1;
        while( i <=k ){
            int poll = pq.poll();
            score+= (long) poll;
            double newNumber = Math.ceil((double) poll/3);
            pq.add((int) newNumber);
            i++;
        }
        return score;
    }
}
