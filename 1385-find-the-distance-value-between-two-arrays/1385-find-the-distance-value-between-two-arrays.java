class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distanceVal = 0;
        
        for(int x: arr1){
            int idx = Arrays.binarySearch(arr2, x);
            
            if(idx >= 0){
                continue;
            }
            
            int insertionPoint = -idx - 1;
            boolean isValid = true;
            
            if(insertionPoint < arr2.length && Math.abs(arr2[insertionPoint] - x) <= d){
                isValid = false;
            }
            
            if(insertionPoint > 0 && Math.abs(arr2[insertionPoint - 1] - x) <= d){
                isValid = false;
            }
            
            if(isValid){
                distanceVal++;
            }
        }
        
        return distanceVal;
    }
}