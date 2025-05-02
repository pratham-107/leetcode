class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashMap<Integer, Boolean> m = new HashMap<>();
        for(int x : banned){
            m.put(x, true);
        }

        int count = 0;
        int sum = 0;
        for(int i=1; i<=n; i++){
            if(!m.containsKey(i) && sum + i <= maxSum){
                sum += i;
                count++;
            }
        }
        return count;
    }
}