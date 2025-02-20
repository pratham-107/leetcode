class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0;
        int ans = Integer.MAX_VALUE;

        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum >= target){
                ans = Math.min(j-i+1, ans);
                sum -= nums[i++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}