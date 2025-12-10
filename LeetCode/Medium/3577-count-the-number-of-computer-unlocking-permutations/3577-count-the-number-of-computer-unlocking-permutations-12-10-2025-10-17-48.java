class Solution {
    static int MOD = 1000000007;
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int first = complexity[0];

        for(int i = 1; i < n; i++) {
            if(complexity[i] <= first) return 0;
        }

        long fact = 1;
        for(int i = 2; i < n; i++) {
            fact = (fact * i) % MOD;
        }
        return (int) fact;
    }
}