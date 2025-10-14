class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        if (n < 2 * k) {
            return false;
        }

        boolean[] canStart = new boolean[n];

        for (int i = 0; i <= n - k; i++) {
            boolean isValid = true;
            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    isValid = false;
                    break;
                }
            }
            canStart[i] = isValid;
        }

        for (int i = 0; i <= n - 2 * k; i++) {
            if (canStart[i] && canStart[i + k]) {
                return true;
            }
        }

        return false;
    }
}