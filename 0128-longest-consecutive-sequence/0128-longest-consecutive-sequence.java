class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap <Integer, Integer> m = new HashMap<>();
        int ans = 0;

        for(int x : nums){
            if(!m.containsKey(x)){
                m.put(x, m.getOrDefault(x - 1, 0) + m.getOrDefault(x+1, 0) + 1);

                m.put(x - m.getOrDefault(x-1, 0), m.get(x));
                m.put(x + m.getOrDefault(x+1, 0), m.get(x));

                ans = Math.max(ans, m.get(x));
            }
        }
        return ans;
    }
}