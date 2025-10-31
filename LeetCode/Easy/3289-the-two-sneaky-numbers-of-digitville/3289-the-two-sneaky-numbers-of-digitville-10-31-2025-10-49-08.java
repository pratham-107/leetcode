class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        int[] ans = new int[2];
        int index = 0;

        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                ans[index++] = nums[i];
            }
        }
        return ans;
    }
}