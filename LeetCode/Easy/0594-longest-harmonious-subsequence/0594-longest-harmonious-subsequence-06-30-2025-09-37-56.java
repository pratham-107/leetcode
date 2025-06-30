class Solution {
    public int findLHS(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> m = new HashMap<>();

        for(int x : nums){
            if(m.containsKey(x)){
                m.put(x, m.get(x) + 1);
            }
            else{
                m.put(x, 1);
            }
        }

        for(int num : m.keySet()){
            if(m.containsKey(num + 1)){
                int curr = m.get(num) + m.get(num + 1);
                if(curr > ans){
                    ans = curr;
                }
            }
        }
        return ans;
    }
}