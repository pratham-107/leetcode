class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int left = 0;
        int right = nums.length -1;

        while(left <= right){
            int mid = (left + right) /2 ;

            if(target == nums[mid]){
                ans[0] = mid;
                right = mid -1;
            }
            if(target > nums[mid]) left  = mid + 1;
            if(target < nums[mid]) right = mid - 1;
        }

        left = 0;
        right = nums.length -1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(target == nums[mid]){
                ans[1] = mid;
                left = mid + 1;
            }
            if(target > nums[mid]) left  = mid + 1;
            if(target < nums[mid]) right = mid - 1;
        }
        return ans;
    }
}