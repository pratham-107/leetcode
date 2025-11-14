class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int xIndex = 0;        
        int yIndex = n;        
        int resIndex = 0;

        for(int i = 0; i < n; i++){
            res[resIndex++] = nums[xIndex++];  
            res[resIndex++] = nums[yIndex++];  
        }
        return res;
    }
}