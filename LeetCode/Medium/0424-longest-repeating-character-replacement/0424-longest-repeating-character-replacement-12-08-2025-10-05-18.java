class Solution {
    public int characterReplacement(String s, int k) {
        int maxCount = 0;
        int[] count = new int[26];
        int l = 0;
        int r = 0;

        for(r = 0; r < s.length(); r++){
            maxCount = Math.max(maxCount, ++count[s.charAt(r) - 'A']);
            if(maxCount + k < r - l + 1){
                --count[s.charAt(l++) - 'A'];
            }
        }
        return r - l;
    }
}