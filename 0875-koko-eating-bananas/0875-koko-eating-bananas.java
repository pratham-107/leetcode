class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i =1;
        int j = 0;

        for(int x : piles){
            if(x > j){
                j = x;
            }
        }

        while(i < j){
            int mid = i + (j-i) / 2;
            if(canEat(piles, h, mid)){
                j = mid;
            } 
            else{
                i = mid + 1;
            }
        }
        return i;
    }
    private static boolean canEat(int[] piles, int h, int k){
        int hours = 0;
        for(int x : piles){
            hours += (x + k - 1) / k;
        }
        return hours <= h;
    }
}