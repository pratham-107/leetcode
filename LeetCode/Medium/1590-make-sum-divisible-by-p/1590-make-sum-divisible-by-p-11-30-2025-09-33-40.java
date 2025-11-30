class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = Arrays.stream(nums).asLongStream().sum();
        int remainder = (int) (sum % p);
        if(remainder == 0){
            return 0;
        }

        int ans = nums.length;
        int prefix = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);

        for(int i = 0; i< nums.length; i++){
            prefix += nums[i];
            prefix %= p;
            int target = (prefix - remainder + p) % p;
            if(m.containsKey(target)){
                ans = Math.min(ans, i - m.get(target));
            }
            m.put(prefix, i);
        }
        return ans == nums.length ? -1 : ans;
    }
}