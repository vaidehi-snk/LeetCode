class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIdx = new int[26];
        for(int i=0; i<s.length(); i++){
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        
        boolean[] seen = new boolean[26];
        StringBuilder stack = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            
            if(seen[curr - 'a']){
                continue;
            }
            
            while(stack.length() > 0 && 
                   stack.charAt(stack.length() - 1) > curr && 
                   lastIdx[stack.charAt(stack.length() - 1) - 'a'] > i){
                
                seen[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }
            
            stack.append(curr);
            seen[curr - 'a'] = true;
        }
        
        return stack.toString();
    }
}