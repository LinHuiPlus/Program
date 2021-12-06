class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        int begin = len-1, end = len-1;
        StringBuilder ss = new StringBuilder();
        int pos = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) != ' '){
                pos = i;
                break;
            }
        }
        for(int i = len-1; i >= 0; i--){
            if(begin == end && s.charAt(i) == ' '){
                begin--;
                end--;
                continue;
            }
            if(i == 0 || i == pos){
                for(int j = i; j <= end; j++){
                    ss.append(s.charAt(j));
                }
                break;
            }
            if(s.charAt(i) != ' '){
                begin--;
            }
            else{
                for(int j = begin + 1; j <= end; j++){
                    ss.append(s.charAt(j));
                }
                ss.append(' ');              
                begin--;
                end = begin;
            }   
        }
        String str = ss.toString();
        return str;
    }
}