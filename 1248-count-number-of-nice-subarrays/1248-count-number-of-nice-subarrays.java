class Solution {
  public int numberOfSubarrays(int[] nums, int k) {
    return Most(nums, k) - Most(nums, k - 1);
  }

  private int Most(int[] nums, int k) {
    int ans = 0;

    for (int i = 0, j = 0; j <= nums.length;)
      if (k >= 0) {
        ans += j - i;
        if (j == nums.length)
          break;
        if (nums[j] % 2 == 1)
          k--;
        j++;
      } else {
        if (nums[i] % 2 == 1)
          k++;
        i++;
      }

    return ans;
  }
}