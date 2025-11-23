class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];

        for(int x : nums) {
            for(int y : dp.clone()) {
                dp[(y + x) % 3] = Math.max(dp[(y  + x) % 3], y + x);
            }
        }
        return dp[0];
    }
}