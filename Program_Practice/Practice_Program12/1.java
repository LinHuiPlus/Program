class TopVotedCandidate {
    int[][] p;
    int max_num = 0;
    int[] per;
    public TopVotedCandidate(int[] persons, int[] times) {
        int len = persons.length;
        this.per = persons;
        for(int i = 0 ; i < len; i++){
            max_num = Math.max(max_num, persons[i]);
        }
        p = new int[max_num+1][len];
        for(int i = 0; i <= max_num; i++){
            for(int j = 0; j < p[i].length; j++){
                p[i][j] = -1;
            }
        }
        for(int i = 0; i < len; i++){
            int len_time = 0;
            for(int j = 0; j < p[persons[i]].length; j++){
                if(p[persons[i]][j] != -1){
                    len_time++;
                }
                else break;
            }
            p[persons[i]][len_time] = times[i];
        }
    }
    public int q(int t) {
        int max = -1, ans = 0, temp_time = 0;
        for(int i = 0; i <= max_num; i++){
            int count = 0, last_time = 0;
            for(int j = 0; j < p[i].length; j++){
                if(p[i][j] == -1) break;
                if(t >= p[i][j]){
                    count++;
                    last_time = p[i][j];
                }
            }
            if(max < count){
                max = count;
                temp_time = last_time;
                ans = i;
            }
            else if(max == count){
                if(last_time > temp_time){
                    temp_time = last_time;
                    ans = i;
                }
            }
        }
        return ans;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */