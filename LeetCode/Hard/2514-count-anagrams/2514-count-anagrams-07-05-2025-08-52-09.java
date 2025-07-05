class Solution {
    public int countAnagrams(String s) {
        int n = s.length();
        long[][] factAndInvFact = getFactAndInvFact(n);
        long[] fact = factAndInvFact[0];
        long[] invFact = factAndInvFact[1];
        long ans = 1;

        for(String x : s.split(" ")){
            ans = ans * fact[x.length()] % MOD;
            int[] count = new int[26];
            for(char c : x.toCharArray()){
                count[c - 'a']++;
            }
            for(int freq : count){
                ans = ans * invFact[freq] % MOD;
            }
        }
        return (int) ans;
    }
    
    private static int MOD = 1_000_000_007;

    private long[][] getFactAndInvFact(int n){
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        long[] inv = new long[n + 1];
        fact[0] = invFact[0] = 1;
        inv[0] = inv[1] = 1;
        
        for(int i = 1; i <= n; i++){
            if(i >= 2){
                inv[i] = MOD - MOD / i * inv[MOD % i] % MOD;
            }
            fact[i] = fact[i - 1] * i % MOD;
            invFact[i] = invFact[i - 1] * inv[i] % MOD;
        }
        return new long[][] {fact, invFact};
    }
}