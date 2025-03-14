class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        long sum = 0;
        
        for (int j = 0; j < nums.length; j++) {
            long target = nums[j];
           sum += target;
            
            if ((j - i + 1) * target - sum > k) {
                sum -= nums[i];
                i++;
            }
        }
        
        return nums.length - i;
    }
}