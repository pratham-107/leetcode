class Solution {
    public int majorityElement(int[] nums) {
        int target = nums[0];
        int count = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] == target){
                count++;
            }else{
                count--;
            }

            if(count == 0){
                target = nums[i];
                count = 1;
            }
        }
        return target;
    }
}