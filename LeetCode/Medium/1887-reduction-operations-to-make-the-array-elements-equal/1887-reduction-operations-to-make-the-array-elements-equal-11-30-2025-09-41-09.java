class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int op = 0;
        int curr = 0;

        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i - 1]){
                curr++;
            }
            op += curr;
        }
        return op;
    }
}