class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(nums);

        for(int i=0; i<queries.length; i++){
            ans[i] = Elements(nums, queries[i]);
        }

        return ans;
    }
    private int Elements(int[] nums, int query){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum > query){
                return i;
            }
        }
        return nums.length;
    }
}