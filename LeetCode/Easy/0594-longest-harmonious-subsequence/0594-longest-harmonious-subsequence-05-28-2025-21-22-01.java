class Solution {
    public int findLHS(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int x : nums){
            m.merge(x, 1, Integer::sum);
        }

        for(int x : m.keySet()){
            if(m.containsKey(x + 1)){
                ans = Math.max(ans, m.get(x) + m.get(x + 1));
            }
        }
        return ans;
    }
}