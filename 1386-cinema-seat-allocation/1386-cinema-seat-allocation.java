class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowMasks = new HashMap<>();
        
        for(int[] seat: reservedSeats){
            int row = seat[0];
            int col = seat[1];
            if(col >= 2 && col <= 9){
                rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << col));
            }
        }
        
        int leftMask = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int rightMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        int midMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        
        int count = 0;
        
        for(int mask: rowMasks.values()){
            boolean left = (mask & leftMask) == 0;
            boolean right = (mask & rightMask) == 0;
            boolean mid = (mask & midMask) == 0;
            
            if(left && right){
                count += 2;
            } else if(left || right || mid){
                count += 1;
            }
        }
        count += (n - rowMasks.size()) * 2;
        
        return count;
    }
}