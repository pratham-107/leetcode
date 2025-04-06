class Solution {
    public int mySqrt(int x) {
        int ans = 0;
        int left = 1;
        int right = x;

        while(left <= right){
             int mid = (left + right) / 2;
                if(mid <= x/mid){
                    ans = mid;
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
        }
        return ans;
    }
}