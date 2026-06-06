class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        int [] answer = new int[n];
        int leftSum = 0;
        for(int i = 0; i < n; i++){
            int rightSum = total - leftSum - nums[i];
            answer[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return answer;
    }
}