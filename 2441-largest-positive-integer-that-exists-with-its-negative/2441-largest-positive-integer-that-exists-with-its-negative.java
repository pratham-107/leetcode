class Solution {
    public int findMaxK(int[] nums) {
        int[] hash = new int[1001];
        Arrays.fill(hash, Integer.MAX_VALUE);
        int ans = -1;

        for(int x : nums){
            if(hash[Math.abs(x)] == Integer.MAX_VALUE){
                hash[Math.abs(x)] = x < 0 ? -1 : 1;
            }
            else{
                if((x < 0 && hash[-x] == 1) || (x > 0 && hash[x] == -1)) 
                ans = Math.max(ans, Math.abs(x));
            }
        }
        return ans;
    }
}