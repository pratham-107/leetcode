class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        int posindex =0, negindex=0;

        for(int x : nums){
            if(x > 0){
                pos[posindex++] = x;
            }
            else{
                neg[negindex++] = x;
            }
        }
        for(int i=0; i<pos.length; i++){
            nums[i*2] = pos[i];
            nums[i*2+1] = neg[i];
        }
        return nums;
    }
}