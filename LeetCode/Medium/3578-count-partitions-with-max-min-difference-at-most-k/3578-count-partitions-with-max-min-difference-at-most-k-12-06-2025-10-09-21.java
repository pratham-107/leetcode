class Solution {
    public int countPartitions(int[] nums, int k) {
        final int MOD = (int) 1e9 + 7;
      
        TreeMap<Integer, Integer> windowElements = new TreeMap<>();
      
        int n = nums.length;
      
        int[] dp = new int[n + 1];
      
        int[] prefixSum = new int[n + 1];
      
        dp[0] = 1;
        prefixSum[0] = 1;
      
        int left = 1;
      
        for (int right = 1; right <= n; right++) {
            int currentNum = nums[right - 1];
          
            windowElements.merge(currentNum, 1, Integer::sum);
          
            while (windowElements.lastKey() - windowElements.firstKey() > k) {
                int leftNum = nums[left - 1];
              
                if (windowElements.merge(leftNum, -1, Integer::sum) == 0) {
                    windowElements.remove(leftNum);
                }
                left++;
            }
          
            int previousSum = (left >= 2) ? prefixSum[left - 2] : 0;
            dp[right] = (prefixSum[right - 1] - previousSum + MOD) % MOD;
          
            prefixSum[right] = (prefixSum[right - 1] + dp[right]) % MOD;
        }
      
        return dp[n];
    }
}