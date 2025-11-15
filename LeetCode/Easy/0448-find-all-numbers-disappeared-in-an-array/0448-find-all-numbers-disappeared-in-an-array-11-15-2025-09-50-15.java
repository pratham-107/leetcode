class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            int x = Math.abs(nums[i]);
            int index = x - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}