class Solution {
    int[] p;
    int[][] f;
    //int temp = 0;
    int row, col;
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        p = new int[row*col];
        f = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int t = i*col+j;
                p[t] = t;
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1 && f[i][j] == 0){
                    merge(i, j, i*col + j, grid);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                f[i][j] = 0;
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1 && p[i*col + j] == i*col + j && f[i][j] == 0){
                    int temp = dfs(i, j, grid);
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }
    public void merge(int i, int j, int x, int[][] grid){
        if(i < 0 || j < 0 || i > row-1 || j > col-1 || f[i][j] == 1 || grid[i][j] == 0){
            return;
        }
        f[i][j] = 1;
        p[i*col + j] = x;
        merge(i, j+1, x, grid);
        merge(i+1, j, x, grid);
        merge(i-1, j, x, grid);
        merge(i, j-1, x, grid);
    }
    public int dfs(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i > row-1 || j > col-1 || f[i][j] == 1 || grid[i][j] == 0){
            return 0;
        }
        f[i][j] = 1;
        return dfs(i, j+1, grid) + dfs(i, j-1, grid) + dfs(i-1, j, grid) + dfs(i+1, j, grid) + 1;
    }
}