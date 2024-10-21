package graphQuestions;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DikshtraAlgorithm {


    public static void main(String[] args) {
        DikshtraAlgorithm dikshtraAlgorithm = new DikshtraAlgorithm();
    }


    /**
     *  a) Select a Source Vertix
     *  b) Initiliazee a Distance array
     *  c) Insert a source in priority Queue
     *  d) iterate the pop element adjancy List
     *  e)
     * @param adjList
     * @param V
     * @return
     */
    static int[] dikshtra(ArrayList<ArrayList<ArrayList<Integer>>> adjList,int V,int S){

        int[] distance = new int[V];
        // initliaze distance matrix
        for(int i = 0;i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[S] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a,b)->Integer.compare(a.distance,b.distance));
        queue.add(new Pair(S,0));

        while( !queue.isEmpty() ){
            int dis = queue.peek().distance;
            int node = queue.peek().vertex;
            queue.poll();

            for(ArrayList<Integer> edge : adjList.get(node)){

                int adjNode = edge.get(0);
                int edgeWeight = edge.get(1);

                if( edgeWeight + dis < distance[adjNode]){
                    distance[adjNode] = edgeWeight + dis;
                    queue.add(new Pair(adjNode,distance[adjNode]));
                }

            }

        }
        return distance;


    }

    static class Pair{

        int vertex;
        int distance;

        Pair(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }

    }
}
