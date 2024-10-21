package graphQuestions;


import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private boolean visited[][] =  null;
    public int numIslands(char[][] grid) {
        // Code here
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++){

            for(int j=0;j<col;j++){

                if(  !visited[i][j] ){
                    bfs( grid, row, col);
                    count++;
                }



            }

        }


        return count;


    }

    private void bfs(char[][] grid,int row,int col){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
//        visited[i][j] = true;


        while(!queue.isEmpty()){
            int[] pop = queue.poll();
            int i = pop[0];
            int j = pop[1];
            // for up  row-1,col
            isValid(queue,grid,i-1,j);

            // for right row , col+1
            isValid(queue,grid,i,j+1);


            // for down -> row+1,col
            isValid(queue,grid,i+1,j);



            //for left -> row , col-1
            isValid(queue,grid,i,j-1);


        }





    }

    private boolean isValid(Queue<int[]> queue, char[][] grid, int row, int col){

//        if(row>=0 && row<grid.length && col>=0 && grid[0].length ){
//            queue.add(new int[]{row,col});
//            visited[row][col] = true;
//            return true;
//        }
        return false;
    }
}
