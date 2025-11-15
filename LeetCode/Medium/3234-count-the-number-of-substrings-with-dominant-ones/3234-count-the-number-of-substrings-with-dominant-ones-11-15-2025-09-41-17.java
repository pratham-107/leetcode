class Solution {

    public int numberOfSubstrings(String s) {

        int ans = 0;
        int n = s.length();

        for (int zero = 0; zero + zero * zero <= n; zero++) {

            int lastInvalidPos = -1;
            int[] count = new int[2];
            int left = 0;

            for (int right = 0; right < n; right++) {

                count[s.charAt(right) - '0']++;

                while (left < right) {
                    char c = s.charAt(left);

                    if (c == '0' && count[0] > zero) {
                        count[0]--;
                        lastInvalidPos = left;
                        left++;
                    } else if (c == '1' && count[1] - 1 >= zero * zero) {
                        count[1]--;
                        left++;
                    } else {
                        break;
                    }
                }

                if (count[0] == zero && count[1] >= zero * zero) {
                    ans += left - lastInvalidPos;
                }
            }
        }

        return ans;
    }
}
