class Solution {
    int[][] f;
    int row, col;
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        f = new int[row][col];
        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                f[i][j] = 0;
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1 && f[i][j] == 0){
                    int temp = dfs(i, j, grid);
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }
    public int dfs(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i > row-1 || j > col-1 || f[i][j] == 1 || grid[i][j] == 0){
            return 0;
        }
        f[i][j] = 1;
        return dfs(i, j+1, grid) + dfs(i, j-1, grid) + dfs(i-1, j, grid) + dfs(i+1, j, grid) + 1;
    }
}