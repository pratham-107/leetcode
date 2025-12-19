class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                temp.add(nums[i]);
            }
        }

        for(int i = 0; i < temp.length; i++){
            nums[i] = temp[i];
        }

        int nonZero = temp.length;
        for(int i = nonZero; i < n; i++){
            nums[i] = 0;
        }
    }
}