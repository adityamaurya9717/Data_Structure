package graphQuestions;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicallySorting {

    public static void main(String[] args) {
        TopologicallySorting topologicallySorting = new TopologicallySorting();
    }


        //Function to return list containing vertices in Topological order.
        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
        {
            // add your code here

            boolean visited[] = new boolean[V];
            Stack<Integer> st = new Stack();

            for(int i=0;i<V;i++){

                if( !visited[i]){
                    dfs(i,adj,visited,st);
                }


            }


            int result[] = new int[st.size()];

            int i=0;
            while(!st.isEmpty()){
                result[i] = st.pop();
                i++;
            }
            return result;
        }
        static void dfs(int u , ArrayList<ArrayList<Integer>>  adjList, boolean[] visited,Stack<Integer> st){

            visited[u]=true;
            for(int adj : adjList.get(u)){
                if(!visited[adj]){
                    dfs(adj,adjList,visited,st);
                }
            }
            st.push(u);


        }
}
