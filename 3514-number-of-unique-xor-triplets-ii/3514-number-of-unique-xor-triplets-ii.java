class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int maxVal = 0;
        for(int num: nums){
            maxVal = Math.max(maxVal, num);
        }

        int upperLimit = 1;
        while(upperLimit <= maxVal){
            upperLimit <<= 1;
        }

        boolean[] pairXors = new boolean[upperLimit];
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                pairXors[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] tripletXors = new boolean[upperLimit];
        for(int pairVal = 0; pairVal < upperLimit; pairVal++){
            if(pairXors[pairVal]){
                for(int num: nums){
                    tripletXors[pairVal ^ num] = true;
                }
            }
        }

        int count = 0;
        for(boolean present: tripletXors){
            if(present){
                count++;
            }
        }

        return count;
    }
}