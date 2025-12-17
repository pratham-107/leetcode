class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < 0 && k > 0){
                nums[i] = -nums[i];
                k--;
            }
        }
        Arrays.sort(nums);

        if(k % 2 != 0){
            nums[0] = -nums[0];
        }

        for(int num : nums){
            sum += num;
        }
        return sum;
    }
}