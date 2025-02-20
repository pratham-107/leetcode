class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int sum =0;

        for(int x : nums){
            if(x == 1){
                sum += x;
            ans = Math.max(ans, sum);
            }
            else{
                sum = 0;
            }
        }
        return ans;
    }
}