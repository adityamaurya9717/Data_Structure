package graphQuestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    public static void main(String[] args) {
        int matrix[][] = {{0,2,1,0,0},
                {2,0,1,0,0},
                {1,1,0,2,2},
                {0,0,2,0,1},
                {0,0,2,1,0}};
        System.out.println(GraphTraversal.convertMatrixGraphToMap(matrix));
        PrimsAlgorithm  algorithm = new PrimsAlgorithm();
        algorithm.mst(matrix);

    }

    /**
     * Minimum Spanning Tree Where we have to calculate The Minimum Spanning Tree and total edge should be
     *  e(u,v),e(u1,u2),e(u2,v2)
     * @param matrix
     */
    public void mst(int[][] matrix){

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.weight,o2.weight);
            }
        });
        List<MST> mst = new ArrayList<>();
        int sum = 0;
        pq.add(new Edge(0,0,-1));

        boolean[] visited = new boolean[matrix.length];

        while( !pq.isEmpty() ){
          Edge poll =  pq.poll();
          if(visited[poll.node]) continue;
          visited[poll.node] = true;
          sum += poll.weight;

          // adding adjacent edges to the priority queue
          for(int i=0;i<matrix[0].length;i++){
              if( matrix[poll.node][i]>0 && !visited[i] ){
                  pq.add(new Edge( matrix[poll.node][i],i,poll.node ));
              }
          }
          mst.add(new MST(poll.weight,poll.node,poll.parent));
          visited[poll.node] = true;

        }
        System.out.println(mst);


        System.out.println("SUM="+sum);

    }

    class Edge{
        public int weight;
        public int node;
        public  int parent;

        public Edge(int weight, int node, int parent){
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }

    class MST{
        public int u;
        public int v;
        public int weight;

        public MST(int u, int v, int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "MST{" +
                    "u=" + u +
                    ", v=" + v +
                    ", weight=" + weight +
                    '}';
        }
    }
}
