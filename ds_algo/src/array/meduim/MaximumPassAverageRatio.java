package array.meduim;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumPassAverageRatio {

    public static void main(String[] args) {
        MaximumPassAverageRatio maximumPassAverageRatio = new MaximumPassAverageRatio();
        int[][] scores = {{2,4},{3,9},{4,5},{2,10}};
        int extraStudents = 4;
        double result = maximumPassAverageRatio.maxAverageRatiohjhj(scores,extraStudents);
        System.out.println(result);
        System.out.printf("%.5f%n", result);

    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max-heap to prioritize classes by their improvement in pass ratio
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            double gain1 = getImprovement(o1[0], o1[1]);
            double gain2 = getImprovement(o2[0], o2[1]);
            return Double.compare(gain2, gain1); // Descending order
        });

        // Add all classes to the queue
        for (int[] c : classes) {
            priorityQueue.offer(c);
        }

        // Assign extra students
        for (int i = 0; i < extraStudents; i++) {
            int[] topClass = priorityQueue.poll(); // Get the class with max improvement
            topClass[0] += 1; // Add a student to passed
            topClass[1] += 1; // Add a student to total
            priorityQueue.offer(topClass); // Push back the updated class
        }

        // Calculate the final average pass ratio
        double totalRatio = 0.0;
        for (int[] c : priorityQueue) {
            totalRatio += (double) c[0] / c[1];
        }

        return totalRatio / classes.length;
    }

    // Calculate the improvement in pass ratio for adding one student
    private double getImprovement(int passed, int total) {
        return ((double) (passed + 1) / (total + 1)) - ((double) passed / total);
    }

    public double maxAverageRatiohjhj(int[][] classes, int extraStudents) {

        double result = 0f;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double a1 = (double) o1[0]/o1[1];
                double a2 = (double) o2[0]/o2[1];
                return Double.compare(a1, a2);
            }
        });

        for(int[] score : classes){
            priorityQueue.add(score);
        }

        while(extraStudents!=0){
            if(priorityQueue.isEmpty()){
                break;
            }
            int[] student = priorityQueue.poll();
            student[0]++;
            student[1]++;
            priorityQueue.add(student);
            extraStudents--;
        }

        while (!priorityQueue.isEmpty()){
            int[] student = priorityQueue.poll();
            result += (double) student[0]/student[1];
        }


        return (double) result/classes.length;

    }


}
