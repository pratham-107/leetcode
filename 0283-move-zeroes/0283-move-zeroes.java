class Solution {
    public void moveZeroes(int[] nums) {
        //optimal solution//
        for(int i=0, j=0; i<nums.length; i++){  //i is traversing from 0 to n//
            if(nums[i] != 0){                   // i i sat non zero element //
                int temp = nums[i];             //swap ith , jth elements//
                nums[i] = nums[j];
                nums[j] = temp;
                j++;                           //move j to next zero//
            }
        }
    }
}