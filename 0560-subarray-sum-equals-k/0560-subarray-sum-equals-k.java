class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);

        int currSum = 0;
        int count = 0;

        for(int num: nums){
            currSum += num;

            int need = currSum - k;
            if(prefixMap.containsKey(need)){
                count += prefixMap.get(need);
            }
            prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}