class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int  MOD  =  1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;
        
        int [][][] dp = new int[m][n][k];
        dp[0][0][grid[0][0] % k] = 1;

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                for(int sum = 0; sum < k; sum++){
                    int newSum = (sum + grid[i][j]) % k;
                    if(i > 0){
                        dp[i][j][newSum] += dp[i - 1][j][sum];
                    }
                    if(j > 0){
                        dp[i][j][newSum] += dp[i][j - 1][sum];
                    }
                    dp[i][j][newSum] %= MOD;
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}