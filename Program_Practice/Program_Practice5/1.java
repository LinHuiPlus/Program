class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0, down = matrix.length-1;
        int colen = matrix[0].length;
        while(up <= down){
            int mid = (up + down)/2;
            int temp = matrix[mid][colen-1];
            if(temp == target) return true;
            if(temp < target) up = up+1;
            if(temp > target) down = down-1;
        }
        if(up >= 0 && colen-1 >=0 && up < matrix.length && matrix[up][colen-1] > target){
            int left = 0, right = colen-1;
            while(left <= right){
                int mid = (left+right)/2;
                int temp = matrix[up][mid];
                if(temp == target) return true;
                if(temp < target) left = left+1;
                if(temp > target) right = right-1;
            }
        }
        if(down >= 0 && colen-1 >= 0 && down < matrix.length && matrix[down][colen-1] > target){
            int left = 0, right = colen-1;
            while(left <= right){
                int mid = (left+right)/2;
                int temp = matrix[down][mid];
                if(temp == target) return true;
                if(temp < target) left = left+1;
                if(temp > target) right = right-1;
            }
        }
        return false;

    }
}