class Solution {
    static long MOD = 1000000007;
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int max = 200000;
        long[] left = new long[max + 1];
        long[] right = new long[max + 1];

        for(int x : nums){
            right[x]++;
        }
        long ans = 0;

        for(int j = 0; j < n; j++) {
            int x = nums[j];
            right[x]--;

            int target = x * 2;
            if(target <= max) {
                ans = (ans + (left[target] * right[target]) % MOD) % MOD;
            }
            left[x]++;
        }
        return (int) ans;
    }
}