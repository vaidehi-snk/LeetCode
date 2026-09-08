class Solution {
    public int countCommas(int n) {
        int totalCommas = 0;
        
        for(int i=1; i<=n; i++){
            int length = String.valueOf(i).length();
            totalCommas += (length-1) / 3;
        }
        
        return totalCommas;
    }
}