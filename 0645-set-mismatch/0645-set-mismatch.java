class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        int[] cnt = new int[n+1];

        for(int x : nums){
            cnt[x]++;
        }

        for(int i=0; i<=n; i++){
            if(cnt[i] == 2){
                ans[0] = i;
            }
            else if(cnt[i] == 0){
                ans[1] = i;
            }
        }
        return ans;
    }
}