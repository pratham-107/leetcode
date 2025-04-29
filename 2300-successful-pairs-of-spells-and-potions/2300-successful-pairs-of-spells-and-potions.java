class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        
        int[] ans = new int[n];
        Arrays.sort(potions);

        for(int i=0; i<n; i++){
            ans[i] = m - firstindex(spells[i], potions, success);
        }
        return ans;
    }
    private int firstindex(int spell, int[] potions, long success){
        int left = 0;
        int right = potions.length;

        while(left < right){
            int mid = left + (right - left) / 2;
            if((long) spell * potions[mid] >= success){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}