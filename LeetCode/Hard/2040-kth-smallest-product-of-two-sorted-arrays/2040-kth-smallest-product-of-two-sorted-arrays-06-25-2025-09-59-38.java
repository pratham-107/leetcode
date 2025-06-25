class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        List<Integer> A1 = new ArrayList<>();
        List<Integer> A2 = new ArrayList<>();
        List<Integer> B1 = new ArrayList<>();
        List<Integer> B2 = new ArrayList<>();
        

        seperate(nums1, A1, A2);
        seperate(nums2, B1, B2);

        long negCount = A1.size() * B2.size() + A2.size() * B1.size();
        int sign = 1;

        if(k > negCount){
          k -= negCount;
        }
        else{
          k = negCount - k + 1;
          sign = -1;
          List<Integer> temp = B1;
          B1 = B2;
          B2 = temp;
        }
        
        long l = 0;
        long r = (long) 1e10;

        while(l < r){
          long m = (l + r) / 2;
          if(numProduct(A1, B1, m) + numProduct(A2, B2, m) >= k){
            r = m;
          }
          else{
            l = m + 1;
          }
        }
        return sign * l;
    }
    private void seperate(int[] arr, List<Integer> A1, List<Integer> A2){
      for(int x : arr){
        if(x < 0){
          A1.add(-x);
        }
        else{
          A2.add(x);
        }
      }
      Collections.reverse(A1);
    }
    private long numProduct(List<Integer> A, List<Integer> B, long m){
      long count = 0;
      int j = B.size() - 1;
      for(long x : A){
        while(j >= 0 && x * B.get(j) > m){
          j--;
        }
        count += j + 1;
      }
      return count;
    }
}