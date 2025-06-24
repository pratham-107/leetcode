class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt((int[] envelope) -> envelope[0]).thenComparingInt((int[] envelope) -> - envelope[1]));

        return lengthOfLIS(envelopes);
    }

    private int lengthOfLIS(int[][] envelopes){
      List<Integer> tail = new ArrayList<>();

      for(int[] x: envelopes){
        int h = x[1];
        if(tail.isEmpty() || h > tail.get(tail.size() - 1)){
          tail.add(h);
        }
        else{
          tail.set(firstGreaterEqual(tail, h), h);
        }
      }
      return tail.size();
    }
    private int firstGreaterEqual(List<Integer> arr, int target){
      int i = Collections.binarySearch(arr, target);
      return i < 0 ? -i -1 : i;
    }
}