class Solution {
    public boolean sumGame(String num) {
        double bal = 0.0;
        int n = num.length();

        for(int i=0; i<n; i++){
            char c = num.charAt(i);
            double val = (c == '?') ? 4.5 : (c - '0');
            
            if(i < n/2){
                bal += val;
            } else{
                bal -= val;
            }
        }

        return bal != 0.0;
    }
}