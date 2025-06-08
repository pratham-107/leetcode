class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int ans = 0;
        int i =0;

        for(int x : houses){
            while(i + 1 < heaters.length && x - heaters[i] > heaters[i + 1] - x){
                i++;
            }
            ans = Math.max(ans, Math.abs(heaters[i] - x));
        }
        return ans;
    }
}