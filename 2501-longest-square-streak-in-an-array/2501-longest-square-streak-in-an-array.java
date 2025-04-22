class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        int ls = 0;

        for(int x : nums){
            if(set.contains(x)) continue;

            int streak = x;
            int slen = 1;

            while(true){
                if((long)streak * (long)streak > 1e5) break;

                if(binarySearch(nums, streak * streak)){
                    streak *= streak;
                    set.add(streak);
                    slen++;
                }
                else{
                    break;
                }
            }
            ls = Math.max(ls, slen);
        }
        return ls < 2 ? -1 : ls;
    }
    private boolean binarySearch(int[] nums, int target){
        if(target < 0) return false;

        int i =0;
        int j = nums.length - 1;

        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] > target) j = mid - 1;
            else i = mid + 1;
        }
        return false;
    }
}