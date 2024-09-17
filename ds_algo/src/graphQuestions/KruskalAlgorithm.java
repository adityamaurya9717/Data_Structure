package graphQuestions;

import javafx.util.Pair;

/**
 * Kruskal Algorithm
 *
 */
public class KruskalAlgorithm {

    public static void main(String[] args) {
        int matrix[][] = {
                {0,5,5,0,0},
                {5,0,5,0,0},
                {7,0,0,5,5},
                {0,0,6,0,8},
                {0,0,6,4,0}};

        Pair<Integer,Integer> pair = findEdgeWithMinimumWeight(matrix);
        System.out.println(pair.toString());
    }

    public static Pair findEdgeWithMinimumWeight(int[][] matrix){
        int u = 0;
        int v = 0;
        int minWeight = Integer.MAX_VALUE;
        for(int i=0; i<matrix.length; i++){
            for (int j=0; j < matrix[0].length;j++ ){
                if( matrix[i][j] > 0 && matrix[i][j] < minWeight){
                     minWeight = matrix[i][j];
                     u = i;
                     v = j;
                }
            }
        }

        return new Pair(u,v);


    }
}
