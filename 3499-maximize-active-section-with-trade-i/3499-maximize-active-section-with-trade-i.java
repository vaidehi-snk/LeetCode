class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1"+s+"1";
        int totalOnes = 0;
        
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        int maxDelta = 0;
        int n = t.length();
        int i=0;
        int prevZeroLen=0;

        while(i<n){
            if(t.charAt(i) == '0'){
                int start = i;
                while(i<n && t.charAt(i) == '0'){
                    i++;
                }
                prevZeroLen = i-start;
            } else{ 
                while(i<n && t.charAt(i) == '1'){
                    i++;
                }
                
                if(prevZeroLen>0 && i<n && t.charAt(i) == '0'){
                    int nextZeroStart = i;
                    while(i<n && t.charAt(i) == '0'){
                        i++;
                    }
                    int nextZeroLen = i-nextZeroStart;
                    maxDelta = Math.max(maxDelta, prevZeroLen + nextZeroLen);
                    prevZeroLen = nextZeroLen;
                }
            }
        }

        return totalOnes + maxDelta;
    }
}