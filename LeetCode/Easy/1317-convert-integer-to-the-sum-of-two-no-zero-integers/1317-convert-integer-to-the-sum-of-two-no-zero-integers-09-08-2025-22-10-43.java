class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; ++a) {
            int b = n - a;
            if (noZero(a) && noZero(b)) {
                return new int[] { a, b };
            }
        }
        return new int[] {};
    }

    private boolean noZero(int n) {
        String s = String.valueOf(n);
        return !s.contains("0");
    }
}