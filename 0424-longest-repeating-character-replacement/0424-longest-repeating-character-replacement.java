class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxlen = 0;
        int[] cnt = new int[26];
        int maxfreq = 0;
        int i =0;

        for(int j=i; j<n; j++){
            cnt[s.charAt(j) - 'A']++;
            maxfreq = Math.max(maxfreq, cnt[s.charAt(j) - 'A']);

            while(j - i + 1 - maxfreq > k){
                cnt[s.charAt(i) - 'A']--;
                i++;
            }
            maxlen = Math.max(maxlen, j-i+1);
        }
        return maxlen;
    }
}