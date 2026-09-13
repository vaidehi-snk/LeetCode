class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] res = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int newCol = (j - rowShift[i] % n + n) % n;
                int newRow = (i - colShift[newCol] % n + n) % n;

                res[newRow][newCol] = grid[i][j];
            }
        }

        return res;
    }
}