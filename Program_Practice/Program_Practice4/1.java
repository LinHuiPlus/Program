class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List L = new ArrayList();
        int m = matrix.length;
        int n = matrix[0].length;
        int right = n, left = -1, up = -1, down = m;
        int state = 0;
        int i = 0, j = 0;
        L.add(matrix[0][0]);
        while(true){
            if(state == 0){
                if(j >= right-1){
                    if(i >= down-1){
                        break;
                    }
                    else{
                        state = 1;
                        i++;
                        up++;
                        L.add(matrix[i][j]);
                    }
                }
                else{
                    j++;
                    L.add(matrix[i][j]);
                }
            }
            else if(1 == state){
                if(i >= down-1){
                    if(j <= left+1){
                        break;
                    }
                    else{
                        state = 2;
                        j--;
                        right--;
                        L.add(matrix[i][j]);
                    }
                }
                else{
                    i++;
                    L.add(matrix[i][j]);
                }
            }
            else if(2 == state){
                if(j <= left+1){
                    if(i <= up+1){
                        break;
                    }
                    else{
                        state = 3;
                        i--;
                        down--;
                        L.add(matrix[i][j]);
                    }
                }
                else{
                    j--;
                    L.add(matrix[i][j]);
                }
            }
            else if(state == 3){
                if(i <= up+1){
                    if(j >= right-1){
                        break;
                    }
                    else{
                        state = 0;
                        j++;
                        left++;
                        L.add(matrix[i][j]);
                    }
                }
                else{
                    i--;
                    L.add(matrix[i][j]);
                }
            }
        }
        return L;
    }
}