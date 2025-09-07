class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int num = 1;

        if (n % 2 != 0) {
            result[n / 2] = 0;
            left = 0;
            right = n / 2 - 1;
            num = 1;
            while (left <= right) {
                result[left++] = num;
                result[n - left] = -num;
                num++;
            }

        } else {
             left = 0;
             right = n - 1;
             num = 1;
            while (left <= right) {
                result[left++] = num;
                result[n - left] = -num;
                num++;
            }
        }
        return result;
    }
}