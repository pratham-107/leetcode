import java.util.*;

class Solution {
  public int[] maxSubsequence(int[] nums, int k) {
    int[] ans = new int[k];
    int[] arr = nums.clone();
    Arrays.sort(arr);
    int threshold = arr[arr.length - k];

    int larger = 0;
    for (int num : nums) {
      if (num > threshold) {
        larger++;
      }
    }

    int equal = k - larger;

    int i = 0;
    for (int num : nums) {
      if (num > threshold) {
        ans[i] = num;
        i++;
      } else {
        if (num == threshold && equal > 0) {
          ans[i] = num;
          i++;
          equal--;
        }
      }

      if (i == k) {
        break;
      }
    }

    return ans;
  }
}
