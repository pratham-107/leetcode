class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int curr = 0;
        int next = 1;

        if(k == 0){
            return true;
        }

        while(curr < n && next < n){
            if(nums[next] == 1){
                if(nums[curr] == 1 && next - curr <= k){
                    return false;
                }
                curr = next;
            }
            next += 1;
        }
        return true;
    }
}