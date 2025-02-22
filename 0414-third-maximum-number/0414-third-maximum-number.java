class Solution {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for(int x : nums){
            if(x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }
            else if(max1 > x && x > max2){
                max3 = max2;
                max2 = x;
            }
            else if(max2 > x && x > max3){
                max3 = x;
            }
        }
        return max3 == Long.MIN_VALUE ? (int) max1 : (int)max3;
    }
}