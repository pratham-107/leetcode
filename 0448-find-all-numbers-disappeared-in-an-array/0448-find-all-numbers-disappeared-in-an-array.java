class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int x : nums){
            int index = Math.abs(x) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        for(int i=0; i<n; i++)
            if(nums[i] > 0) 
            ans.add(i+1);
            return ans;
    }
}