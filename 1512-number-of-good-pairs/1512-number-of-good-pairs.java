class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] hash = new int[101];
        for(int x : nums) hash[x]++;

        int count = 0;
        for(int x : hash){
            count += (x * (x-1)) / 2;
        }
        return count;
    }
}