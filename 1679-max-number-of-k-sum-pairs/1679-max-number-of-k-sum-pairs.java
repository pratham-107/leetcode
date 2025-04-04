class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int operation = 0;

        for(int x : nums){
            int count = k - x;

            if(m.containsKey(count) && m.get(count) > 0){
                operation++;
                m.put(count, m.get(count) - 1);
            }
            else{
                m.put(x, m.getOrDefault(x, 0) + 1);
            }
        }
        return operation;
    }
}