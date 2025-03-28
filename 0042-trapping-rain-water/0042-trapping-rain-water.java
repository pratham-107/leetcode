class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        int sum = 0;

        for(int i=0; i<n; i++){
            left[i] = max;
            if(height[i] > max){
                max = height[i];
                left[i] = height[i];
            }
        }
        max = 0;
        for(int i=n-1; i>=0; i--){
            right[i] = max;
            if(height[i] > max){
                max = height[i];
                right[i] = height[i];
            }
        }
        for(int i=0; i<n; i++){
           int ans = Math.min(left[i] , right[i]);
            sum += ans - height[i];
        }
        return sum;
    }
}