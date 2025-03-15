class Solution {
    public int removeDuplicates(int[] nums) {
        int i =0;
        for(int x : nums){
            if(i < 2 || x > nums[i-2]){
                nums[i] = x;
                i++;
            }
        }
        return i;
    }
}