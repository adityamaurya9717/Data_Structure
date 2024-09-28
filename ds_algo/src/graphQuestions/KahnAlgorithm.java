package graphQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgorithm {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = getGraph();
        int V = graph.size();
        topologicallySort(V, graph);


    }

    /**
     *  step 1)  Find out the Indegree( No Of Incoming Edges) of All the Nodes
     *  step 2)  Insert the Nodes in Queue Where degree is 0 as it means less nodes are dependent on it
     *  step 3) pop from Queue and decrease it adjancency node degree to 1
     *  step 4) if degree is 0 insert in queue
     * @param V
     * @param adj
     */
    public static void topologicallySort(int V,ArrayList<ArrayList<Integer>> adj){

        // inserting degree into array
        int[] degree = new int[V];
        for(int i=0;i<V;i++){
            for(int v: adj.get(i)){
                degree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(degree[i]==0){
                queue.add(i);
            }
        }
        System.out.println(Arrays.toString(degree));
        System.out.println(queue);
        int result[] = new int[V];
        int index = 0;

        while (!queue.isEmpty()){
            int u = queue.poll();
            result[index++] = u;

            for(int v : adj.get(u)){
                degree[v]--;
                if(degree[v]==0){
                    queue.add(v);
                }
            }

        }
        System.out.println(Arrays.toString(result));

    }
    static ArrayList<ArrayList<Integer>> getGraph(){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 6;
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).addAll(Arrays.asList());
        graph.get(1).addAll(Arrays.asList());
        graph.get(2).addAll(Arrays.asList(3));
        graph.get(3).addAll(Arrays.asList(1));
        graph.get(4).addAll(Arrays.asList(0,1));
        graph.get(5).addAll(Arrays.asList(0,2));
        return graph;
    }
}
