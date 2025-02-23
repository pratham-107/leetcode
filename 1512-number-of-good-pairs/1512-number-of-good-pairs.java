class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] hash = new int[101];
        int ans = 0;
        for(int x : nums) ans += hash[x]++;
        return ans;
    }
}