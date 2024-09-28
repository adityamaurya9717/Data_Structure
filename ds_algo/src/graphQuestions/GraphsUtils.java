package graphQuestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static int[][]  convertEdgeListToMatrix(List<List<Integer>> edgeList){

        Set<Integer> set = new HashSet<Integer>();
        for (List<Integer> edge : edgeList){
            set.add(edge.get(0));
            set.add(edge.get(1));
        }
        int totalVertix = set.size();

        int matrix[][] = new int[totalVertix][totalVertix];
        for (List<Integer> edge : edgeList){
            int u = edge.get(0);
            int v = edge.get(1);
            matrix[u][v] = 1;
        }
        return matrix;

    }
    public static Map<Integer,List<Integer>> convertMatrixToEdgeList(int[][] matrix){

        Map<Integer,List<Integer>> mapGraph = new HashMap();
        for (int u=0; u<matrix.length; u++){
            for(int v=0;v<matrix.length;v++){
                if(matrix[u][v] == 1){
                    mapGraph.computeIfAbsent(u,k->new ArrayList<>()).add(v);
                }
            }
        }
        return mapGraph;
    }
}
