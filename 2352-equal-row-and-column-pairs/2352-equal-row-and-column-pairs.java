class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int k;
                for(k=0;k<n; k++){
                    if(grid[i][k] != grid[k][j]){
                        break;
                    }
                }
                if(k == n){
                    ans++;
                }
            }
        }
        return ans;
    }
}