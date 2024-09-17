package graphQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphsUtils {

    public static void main(String[] args) {


        Map<Integer, List<Integer>> mapGraph = GraphsUtils.createGraph();
        int[][] matrixGraph = convertMapGraphToMatrixGraph(mapGraph);
        System.out.println("Matrix representation of graph: ");
        for (int[] row : matrixGraph){
            for (int cell : row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static Map<Integer, List<Integer>> createGraph() {
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        map.put(0, Arrays.asList(1,2));
        map.put(1,Arrays.asList(0,3));
        map.put(2,Arrays.asList(0,3));
        map.put(3,Arrays.asList(4,2));
        map.put(4,Arrays.asList(3));
        return map;
    }


    public static int[][] convertMapGraphToMatrixGraph(Map<Integer, List<Integer>> mapGraph){

        int[][] matrixGraph = new int[mapGraph.size()][mapGraph.size()];

        for ( Map.Entry<Integer, List<Integer>> entry : mapGraph.entrySet()){
            int vertex = entry.getKey();
            List<Integer> adjacentVertices = entry.getValue();
            for (int adjacentVertex : adjacentVertices){
                matrixGraph[vertex][adjacentVertex] = 1;
            }
        }
        return matrixGraph;
    }
}
