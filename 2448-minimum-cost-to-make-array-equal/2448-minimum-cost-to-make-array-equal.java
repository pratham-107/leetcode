class Solution {
    public long minCost(int[] nums, int[] cost) {
        long ans = 0;
        int l = Arrays.stream(nums).min().getAsInt();
        int r = Arrays.stream(nums).max().getAsInt();

        while(l < r){
            int m = l + (r - l) / 2;
            long cost1 = getcost(nums, cost, m);
            long cost2 = getcost(nums, cost, m + 1);
            ans = Math.min(cost1, cost2);

            if(cost1 < cost2){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        return ans;
    }
    private long getcost(int[] nums, int[] cost, int target){
        long res = 0;
        for(int i=0; i<nums.length; i++){
            res += Math.abs(nums[i] - target) * (long) cost[i]; 
        }
        return res;
    }
}