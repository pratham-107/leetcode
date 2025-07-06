class Solution {
    public long kMirror(int k, int n) {
        long ans = 0;
        char[] A = new char[] {'0'};

        for (int i = 0; i < n; i++) {
            while (true) {
                A = nextKMirror(A, k);
                long num = Long.parseLong(new String(A), k);
                if (isPalindrome(num)) {
                    ans += num;
                    break;
                }
            }
        }

        return ans;
    }

    private char[] nextKMirror(char[] A, int k) {
        int len = A.length;
        for (int i = len / 2; i < len; i++) {
            int nextNum = A[i] - '0' + 1;
            if (nextNum < k) {
                A[i] = (char) (nextNum + '0');
                A[len - 1 - i] = (char) (nextNum + '0');
                for (int j = len / 2; j < i; j++) {
                    A[j] = '0';
                    A[len - 1 - j] = '0';
                }
                return A;
            }
        }
        char[] newA = new char[len + 1];
        newA[0] = '1';
        Arrays.fill(newA, 1, len, '0');
        newA[len] = '1';
        return newA;
    }

    private boolean isPalindrome(long num) {
        String str = Long.toString(num);
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
