class Solution {
    public int findMaxK(int[] nums) {
        HashMap <Integer, Integer> m = new HashMap<> ();
        int ans = -1;

        for(int i=0; i<nums.length; i++){
            if(m.containsKey(nums[i] * -1)){
                ans = Math.max(ans, Math.abs(nums[i]));
            }
            m.put(nums[i], i);
        }
        return ans;
    }
}