class Solution {
    public boolean validTicTacToe(String[] board) {
        int xsum = 0, osum = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) == 'X'){
                    xsum++;
                }
                else if(board[i].charAt(j) == 'O'){
                    osum++;
                }
            }
        }
        if(xsum < osum) return false;
        if(Math.abs(xsum - osum) > 1 || (xsum == 0 && osum >= 1)) return false;
        int xcount = 0, ocount = 0;
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(0) == board[i].charAt(2)){
                if(board[i].charAt(0) == 'X'){
                    xcount++;
                }
                else if(board[i].charAt(0) == 'O'){
                    ocount++;
                }
            }
        }

        for(int j = 0; j < 3; j++){
            char c = board[0].charAt(j);
            int flag = 1;
            for(int i = 1; i < 3; i++){
                if(board[i].charAt(j) != c){
                    flag = 0;
                }
            }
            if(flag == 1){
                if(c == 'X'){
                    xcount++;
                }
                else if(c == 'O'){
                    ocount++;
                }
            }
        }
        if(board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2)){
            if(board[0].charAt(0) == 'X'){
                xcount++;
            }
            else if(board[0].charAt(0) == 'O'){
                ocount++;
            }
        }
        if(board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) == board[2].charAt(0)){
            if(board[0].charAt(2) == 'X'){
                xcount++;
            }
            else if(board[0].charAt(2) == 'O'){
                ocount++;
            }
        }
        if(xcount >= 1 && ocount >= 1) return false;
        if(xcount == 1 && xsum == osum) return false;
        if(ocount == 1 && xsum > osum) return false;
        return true;
    }

}