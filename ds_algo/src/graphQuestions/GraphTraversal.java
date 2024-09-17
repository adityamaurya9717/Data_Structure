package graphQuestions;

import java.util.*;

public class GraphTraversal {

    public static Set<Integer> isVisited = new HashSet<>();

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 1, 1}
        };

        bfsTraversal(graph);
       // dfsTraversal(graph);
       // convertMatrixGraphToMap(graph);
        
    }

    private static void bfsTraversal(int[][] graph) {
        int startIndex = 0;
        isVisited.clear();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        isVisited.add(startIndex);

        while( !queue.isEmpty() ){
            int currentNode = queue.poll();
            isVisited.add(currentNode);

            for(int i=0;i<graph.length;i++){
                int hasEdge = graph[currentNode][i];
                if(hasEdge==1){
                    System.out.println("current node " + currentNode + "To Edge="+i +" )");
                }
                if( hasEdge==1 && currentNode == i){
                    throw new RuntimeException("Has Self Loop for " + currentNode);
                }
                if( hasEdge==1 && !isVisited.contains(i) ){
                    queue.add(i);
                }
            }

        }
        //////
//
//        int startIndex = 0;
//        isVisited.clear();
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(startIndex);
//        isVisited.add(startIndex); // Mark as visited when enqueuing
//
//        while (!queue.isEmpty()) {
//            int currentNode = queue.poll();
//            System.out.println("Visiting node " + currentNode);
//
//            for (int i = 0; i < graph.length; i++) {
//                int hasEdge = graph[currentNode][i];
//                if (hasEdge == 1 && !isVisited.contains(i)) {
//                    System.out.println("current node " + currentNode + " to Edge=" + i);
//                    queue.add(i);
//                    isVisited.add(i); // Mark as visited when enqueuing
//                }
//            }
//        }
    }

    public static void dfsTraversal(int[][] graph){
        dfs(graph,0);


    }
    public static void dfs(int[][] graph, int currentNode) {
        isVisited.add(currentNode);
        for (int i = 0; i < graph.length; i++) {
            int hasEdge = graph[currentNode][i];
            if(hasEdge==1){
            }
            if (hasEdge == 1 &&!isVisited.contains(i)) {
                System.out.println("e ( "+currentNode +" , "+i+" )");

                dfs(graph, i);
            }
        }

    }

    /**
     * This only convert directed graph
     * @param matrix
     * @return
     */
    public static Map<Integer,List<Integer>> convertMatrixGraphToMap(int[][] matrix){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Map<Integer,List<Integer>> map = new LinkedHashMap<>();

        while (!queue.isEmpty() ){

            int currentNode = queue.poll();
            if(visited.contains(currentNode)) continue;

            visited.add(currentNode);

            for(int i=0; i<matrix.length; i++){
                int hasEdge = matrix[currentNode][i];
                if (hasEdge>0 ){
                    map.computeIfAbsent(currentNode,k -> new ArrayList<>()).add(i);

                }
                if (hasEdge>0 && !visited.contains(i)){
                    queue.add(i);

                }

            }
        }
        System.out.println(map);

return map;
    }



}
