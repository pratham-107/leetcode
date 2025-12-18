class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        for(int j = 1; j < n; j++){
            if(nums[i] != nums[j]){
                nums[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }
}