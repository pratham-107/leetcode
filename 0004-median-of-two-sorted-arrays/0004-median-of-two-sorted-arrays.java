class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n + m];
        mergearr(nums1, nums2, arr);

        double ans = 0.0;
        if (arr.length % 2 == 1) ans = (double) arr[arr.length / 2];
        else ans = (double)(arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        
        return ans;
    }

    public void mergearr(int[] num1, int[] num2, int[] arr) {
        int n = num1.length, m = num2.length;
        int p1 = 0, p2 = 0, i = 0;
        
        while (p1 < n && p2 < m) {
            if (num1[p1] < num2[p2]) arr[i++] = num1[p1++];
            else arr[i++] = num2[p2++];
        }

        while (p1 < n) arr[i++] = num1[p1++];
        while (p2 < m) arr[i++] = num2[p2++];
    }
}
