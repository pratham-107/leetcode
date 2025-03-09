class Solution {
    public int mostFrequent(int[] nums, int key) {
        int[] hash = new int[10001];
        for(int i=0; i<nums.length - 1; i++){
            if(nums[i] == key) hash[nums[i+1]]++;
        }
        int ans = -1;
        int max = 0;

        for(int i=0; i<10001; i++){
            if(hash[i] > max){
                ans = i;
                max = hash[i];
            }
        }
        return ans;
    }
}