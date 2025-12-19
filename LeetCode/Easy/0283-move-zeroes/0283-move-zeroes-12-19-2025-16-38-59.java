class Solution {
    void swap(int[] nums, int n){
            for(int i = 0; i < n -1; i++){
                if(nums[i] == 0 && nums[i + 1] != 0){
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            swap(nums, n);
        }
    }
}