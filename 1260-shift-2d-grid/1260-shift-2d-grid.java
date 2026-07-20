class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int totalElements = m * n;
        
        k = k % totalElements;
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<m; i++){
            result.add(new ArrayList<>());
        }
        
        for(int i=0; i<totalElements; i++){
            int oldIdx = (i - k + totalElements) % totalElements;
            
            int r = oldIdx / n;
            int c = oldIdx % n;
            
            result.get(i/n).add(grid[r][c]);
        }
        
        return result;
    }
}