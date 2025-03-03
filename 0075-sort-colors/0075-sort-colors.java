class Solution {
    public void sortColors(int[] nums) {
        int red=0;
        int white=0;
        int blue=0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i] == 0) red++;
            else if(nums[i] == 1) white++;
            else blue++;
        }

        for(int i=0; i<red; i++) nums[i]=0;
        for(int i=red; i<red + white; i++) nums[i]=1;
        for(int i= red + white; i < n; i++) nums[i] =2;
    }
}