class Solution {
    public int longestSubsequence(String s, int k) {
        int cnt = 0;
        int num = 0;
        int pow = 1;

        for(int i= s.length() -1; i >= 0 && num + pow <= k; i--){
            if(s.charAt(i) == '1'){
                cnt++;
                num += pow;
            }
            pow *= 2;
        }
        return (int) s.chars().filter(c -> c == '0').count() + cnt;
    }
}