class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int ans = n;
        int[] count = new int[3];

        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        if(count[0] < k || count[1] < k || count[2] < k){
            return -1;
        } 

        for(int l=0, r=0; r<n; r++){
            count[s.charAt(r) - 'a']--;
            while(count[s.charAt(r) - 'a'] < k){
                count[s.charAt(l) - 'a']++;
                l++;
            }
            ans = Math.min(ans, n - (r- l + 1));
        }
        return ans;
    }
}