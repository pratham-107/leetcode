class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
         for (int k = 1; k <= 60; k++) {
            long val = (long) num1 - (long) k * (long) num2;

            if (val < k) break;
            if (Long.bitCount(val) <= k) return k;
        }
        return -1;
    }
}