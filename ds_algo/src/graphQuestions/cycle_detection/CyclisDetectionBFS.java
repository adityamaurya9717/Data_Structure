package graphQuestions.cycle_detection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CyclisDetectionBFS {


    private boolean[] visited = null;
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        boolean hasCycle = false;
        visited = new boolean[V];

        for(int i=0;i<V;i++){

            if( !visited[i] ){
                if ( bfs(i,adj)) return true;
            }

        }

        return hasCycle;


    }

    private boolean bfs( int u , ArrayList<ArrayList<Integer>> adjList ){

        int V = adjList.size();
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{u,-1});

        while(!queue.isEmpty()){
            int [] poll = queue.poll();

            int node = poll[0];
            int parent = poll[1];

            visited[node] = true;
            for( int adj : adjList.get(node) ){

                if(!visited[adj]){
                    visited[adj] = true;
                    queue.add( new int[]{adj,node} );
                }
                else if( adj!=parent){
                    return true;
                }
            }
        }
        return false;


    }
}
