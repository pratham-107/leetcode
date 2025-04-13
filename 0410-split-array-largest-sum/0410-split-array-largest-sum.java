class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for(int x : nums){
            low = Math.max(low, x);
            high += x;
        }

        while(low < high){
            int mid = (low + high) / 2;
            if(split(nums, k, mid)){
                high =  mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    boolean split(int[] nums, int k, int maxsum){
        int count = 1;
        int sum = 0;
        for(int x : nums){
            sum += x;
            if(sum > maxsum){
                count++;
                sum = x;
            }
        }
        return count <= k;
    }
}