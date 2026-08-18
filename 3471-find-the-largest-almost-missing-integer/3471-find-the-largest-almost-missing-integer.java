class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        if(k == 1){
            int ans = -1;
            for(Map.Entry<Integer, Integer> entry : count.entrySet()){
                if(entry.getValue() == 1){
                    ans = Math.max(ans, entry.getKey());
                }
            }
            return ans;
        }
        if(k == n){
            int maxVal = -1;
            for(int num: nums){
                maxVal = Math.max(maxVal, num);
            }
            return maxVal;
        }

        int ans = -1;
        if(count.get(nums[0]) == 1){
            ans = Math.max(ans, nums[0]);
        }
        if(count.get(nums[n - 1]) == 1){
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}