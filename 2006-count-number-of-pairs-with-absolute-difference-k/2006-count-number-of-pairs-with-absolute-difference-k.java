class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] hash = new int[101];
        int ans = 0;
        for(int x : nums) hash[x]++;

        for(int i=k+1; i<101; i++){
            ans += hash[i] * hash[i-k];
        }
        return ans;
    }
}