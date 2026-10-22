class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return 0;
        }
        int k = 0;
        for(int i=0; i<n; i++){
            if (nums[i] == 0) {
                k = i;
                break;
            }
        }
        boolean isInc = true;
        for(int i=0; i<n; i++) {
            if(nums[i] != (i-k+n) % n){
                isInc = false;
                break;
            }
        }

        if(isInc){
            if(k == 0){
                return 0;
            }
            return Math.min(k, n - k + 2);
        }

        boolean isDec = true;
        for(int i=0; i<n; i++){
            if (nums[i] != (k - i + n) % n) {
                isDec = false;
                break;
            }
        }

        if(isDec){
            int op1 = 1 + (n - 1 - k);
            int op2 = 1 + ((k + 1) % n);
            return Math.min(op1, op2);
        }

        return -1;
    }
}