class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currCount = 0;
        for(int x : nums){
            if(x == 1){
                currCount++;
                maxCount = Math.max(maxCount, currCount);
            }
            else{
                currCount = 0;
            }
        }
        return maxCount;
    }
}