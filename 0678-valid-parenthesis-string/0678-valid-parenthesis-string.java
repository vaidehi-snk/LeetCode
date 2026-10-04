class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0;
        int cmax = 0;

        for(char c: s.toCharArray()){
            if(c == '('){
                cmin++;
                cmax++;
            } else if (c == ')') {
                cmin--;
                cmax--;
            } else if(c == '*'){
                cmin--;
                cmax++;
            }
            if(cmax<0){
                return false;
            }
            if(cmin<0){
                cmin = 0;
            }
        }
        return cmin == 0;
    }
}