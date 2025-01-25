package bfs;

public class NoOfIsland {


    boolean[][] visited = null;

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        NoOfIsland noOfIsland = new NoOfIsland();
        int res = noOfIsland.numIslands(grid);
        System.out.println(res);



    }

    /**
     *  validatePosition(row, column,grgid)
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];

        int count = 0;

        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<grid[i].length;j++){
                if( grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid,i,j);
                    visited[i][j] = true;
                    count++;
                }

            }
        }


        return count;

    }

    private void dfs(char[][] grid, int row, int col) {

        if( !validatePosition(grid,row,col)){
            return;
        }
        if(visited[row][col]){
            return;
        }

        // top , right , bottom , left
        int directions[][] = {
                {-1,0},
                {0,1},
                {1,0},
                {0,-1}
        };
        visited[row][col] = true;

        for(int i=0;i<directions.length;i++){
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            dfs(grid,newRow,newCol);
        }


    }

    public boolean validatePosition(char[][] grid,int row,int col){

        if(row < 0 || row >= grid.length){
            return false;
        }
        if(col < 0 || col >= grid[0].length ){
            return false;
        }
        if(grid[row][col] == '0'){
            return false;
        }
        return true;


    }
}
