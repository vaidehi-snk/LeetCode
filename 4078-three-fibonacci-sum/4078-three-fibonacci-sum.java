class Solution {
    public boolean threeFibonacciSum(int n) {
        if(n%2 != 0){
            return false;
        }

        long target = n / 2;
        long x = 0;
        long y = 1;
        
        while(y < target){
            long next = x + y;
            x = y;
            y = next;
        }
        
        return y == target;
    }
}