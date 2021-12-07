class Solution {
    int row_len;
    int col_len;
    int[][] p;
    int[][] f;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        row_len = grid.length;
        col_len = grid[0].length;
        p = new int[row_len][col_len];
        f = new int[row_len][col_len];
        reset();
        dfs(row, col, grid, color, grid[row][col]);
        reset();
        change(row, col, grid, color, grid[row][col]);
        return grid;
    }
    public void reset(){
        for(int i = 0; i < row_len; i++){
            for(int j = 0; j < col_len; j++){
                p[i][j] = 0;
            }
        }
    }
    public void change(int i, int j, int[][] grid, int color, int t_color){
        if(i < 0 || j < 0 || i >= row_len || j >= col_len || p[i][j] == 1){
            return;
        }
        p[i][j] = 1;
        if(f[i][j] == 1){
            grid[i][j] = color;
        }
        change(i, j-1, grid, color, t_color);
        change(i, j+1, grid, color, t_color);
        change(i-1, j, grid, color, t_color);
        change(i+1, j, grid, color, t_color);
    }
    public void dfs(int i, int j, int[][] grid, int color, int t_color){
        if(i < 0 || j < 0 || i >= row_len || j >= col_len || p[i][j] == 1 || grid[i][j] != t_color){
            return;
        }
        p[i][j] = 1;
        if(i == 0 || j == 0 || i == row_len-1 || j == col_len-1 || grid[i-1][j] != t_color || grid[i+1][j] != t_color || grid[i][j-1] != t_color || grid[i][j+1] != t_color){
            f[i][j] = 1;
        }
        dfs(i, j-1, grid, color, t_color);
        dfs(i, j+1, grid, color, t_color);
        dfs(i-1, j, grid, color, t_color);
        dfs(i+1, j, grid, color, t_color);
    }
}
