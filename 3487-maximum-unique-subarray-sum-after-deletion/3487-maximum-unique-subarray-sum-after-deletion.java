class Solution {
    public int maxSum(int[] nums) {
        int sum = 0;
        int max = -1000;

        Set<Integer> s = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);

            if(nums[i] <= 0 || s.contains(nums[i])) continue;
            sum += nums[i];
            s.add(nums[i]);
        }

        return max <= 0 ? max : sum;
    }
}