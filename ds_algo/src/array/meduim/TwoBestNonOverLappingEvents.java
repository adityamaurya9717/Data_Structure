package array.meduim;

import java.util.Arrays;

public class TwoBestNonOverLappingEvents {

    public static void main(String[] args) {
        TwoBestNonOverLappingEvents twoBestNonOverlappingEvents = new TwoBestNonOverLappingEvents();
        int[][] events = {{1,3,2},{4,5,2},{2,4,3}};
       int result = twoBestNonOverlappingEvents.maxTwoEvents(events);
        System.out.println(result);
    }

    private int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> b[2] - a[2]);
        return solve(events);
    }

    private int solve(int[][] events) {
        return 0;
    }

    public int maxTwoEventsIterative(int[][] events) {
        int result = 0;
        int n = events.length;
        for(int i=0;i<n;i++){
            int[] temp = events[i];
            result = Math.max(result, temp[2]);
            for(int j=0;j<n;j++){
                int[] current = events[j];
                int value = current[2];
                if(i==j) continue;
                // if overlap skip
                if(current[0] <= temp[1] ){

                }
                else{
                    result = Math.max(result,temp[2] + value);
                }
            }
        }

        return result;

    }
}
