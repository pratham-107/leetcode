class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 0, high = (int)1e9, ans = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(ispossible(mid, bloomDay, m, k)){
                ans = mid;
                high =  mid -1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    boolean ispossible(int mid, int[] bloomDay, int m, int k){
        int adj = 0;
        int b = 0;

        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                adj++;
                if(adj == k){
                    b++;
                    adj = 0;
                }
            }
            else{
                adj = 0;
            }
        }
        return b >= m;
    }
}