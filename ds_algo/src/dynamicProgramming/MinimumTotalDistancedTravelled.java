package dynamicProgramming;

import java.util.*;

public class MinimumTotalDistancedTravelled {

    long[][] memo = null;

    public static void main(String[] args) {
        MinimumTotalDistancedTravelled minimumTotalDistancedTravelled = new MinimumTotalDistancedTravelled();
        List<Integer> robots = Arrays.asList(0,4,6);
        int[][] factory = {{2, 2}, {6, 2}};
       long result=  minimumTotalDistancedTravelled.minimumTotalDistance(robots, factory);
        System.out.println("result="+result);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        Collections.sort(robot);
        Arrays.sort(factory,(a1,a2)-> Integer.compare(a1[0],a2[0]));
        //
        List<Integer> positions = new ArrayList<>();
        for(int i=0;i<factory.length;i++){
            for(int j=0;j<factory[i][1];j++){
                positions.add(factory[i][0]);
            }
        }
        System.out.println(robot);
        System.out.println(positions);
        memo = new long[robot.size()][positions.size()];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }


        long result = solve(robot,0,positions,0);
        return result;

    }

    private long solve(List<Integer> robot,int robotIndex,List<Integer> positions,int positionIndex){
        if(robotIndex >= robot.size()) {
            return 0;
        }
        if(positionIndex >= positions.size()) {
            return (long) 1e12;
        }
        if(memo[robotIndex][positionIndex]!=0) {
            return memo[robotIndex][positionIndex];
        }
        long include = Math.abs( (long)robot.get(robotIndex) - (long)positions.get(positionIndex) ) +  solve(robot,robotIndex+1,positions,positionIndex+1);
        long exclude = solve(robot,robotIndex,positions,positionIndex+1);

        return memo[robotIndex][positionIndex] = Math.min(include, exclude);


    }
}
