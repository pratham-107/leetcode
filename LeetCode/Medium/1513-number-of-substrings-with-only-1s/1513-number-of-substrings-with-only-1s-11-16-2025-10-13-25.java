class Solution {
    public int numSub(String s) {
        final int mod = 1000000007;
        long count = 0, ans = 0;
        
        for(char c : s.toCharArray()){
            ans += (1 - (c - '0')) * count * (count + 1) / 2;
            count = (c - '0') * (count + 1);
        }
        ans += count * (count + 1) / 2;
        return (int) (ans % mod);
    }
}