class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if(nums.length == 0 || indexDiff <= 0 || valueDiff < 0){
          return false;
        }
        long mn = Arrays.stream(nums).min().getAsInt();
        long diff = (long) valueDiff  + 1;
        HashMap<Long, Long> bucket = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
          long num = (long) nums[i];
          long key = getKey(nums[i], mn, diff);
          if(bucket.containsKey(key)){
            return true;
          }
          if(bucket.containsKey(key - 1) && num - bucket.get(key - 1) < diff){
            return true;
          }
          if(bucket.containsKey(key + 1) && bucket.get(key + 1) - num < diff){
            return true;
          }
          bucket.put(key, num);
          if(i >= indexDiff){
            bucket.remove(getKey(nums[i - indexDiff], mn, diff));
          }
        } 
      return false;
    }
    private long getKey(int num, long mn, long diff){
      return ((long) num - mn) / diff;
    }
}