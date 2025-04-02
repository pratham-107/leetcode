class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int cnt = 0;

        for(int i=0, j=0; j<n; j++){
            if(nums[j] == 0) cnt++;

            while(cnt == 2)
            if(nums[i++] == 0) cnt--;
            
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}