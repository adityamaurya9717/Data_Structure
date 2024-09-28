package graphQuestions;

import java.util.*;

public class GraphDFSTraversal {

    public static void main(String[] args) {
        GraphDFSTraversal graph = new GraphDFSTraversal();
        int matrix[][] = {{0,1,1,0,0},
                          {1,0,1,0,0},
                          {1,1,0,1,1},
                          {0,0,1,0,1},
                          {0,0,1,1,0}};
        GraphDFSTraversal graphTraversal = new GraphDFSTraversal();
        graphTraversal.bfstraversal(matrix);
        //System.out.println(GraphsUtils.convertMatrixToEdgeList(matrix));
    }

    private void bfstraversal(int[][] matrix) {

        boolean[] visited = new boolean[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while ( !queue.isEmpty() ){
            int u =queue.poll();
            visited[u] = true;
            System.out.print(u + " "); //
            for( int v = 0; v < matrix.length; v++ ){
                // there is a path
                if( matrix[u][v]==1 && !visited[v]){
                     queue.add(v);
                     visited[v]=true;
                }
            }
        }
    }
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<Integer> result = new ArrayList();
        boolean visited[] = new boolean[V];

        Queue<Integer> queue = new LinkedList();
        queue.add(0);

        while( !queue.isEmpty()){

            int u =  queue.poll();
            visited[u] = true;
            result.add(u);

            for(int v : adj.get(u) ){
                if(!visited[v]){
                    queue.add(v);
                    visited[v] = true;

                }
            }
        }

        return result;



    }

    private void dfsTraversal(int[][] matrix) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[matrix.length];
        stack.add(0);
        visited[0] = true;

        while (!stack.isEmpty() ) {
            int u = stack.pop();
            for(int v=0;v<matrix.length;v++){
                if(matrix[u][v]==1 && !visited[v]){
                    stack.push(v);
                    visited[v]=true;
                }
            }
        }
    }

    private void dfsUtils(int[][] matrix){
        boolean[] visited = new boolean[matrix.length];
                dfsTraversal(matrix, 0, visited);

    }

    private void dfsTraversal(int[][] matrix,int u,boolean[] visited) {
        System.out.println(u);
        for(int v=0;v<matrix.length;v++){
            if(matrix[u][v]==1 && !visited[v]){
                visited[v]=true;
                dfsTraversal(matrix, v, visited);
            }

        }
    }

}
