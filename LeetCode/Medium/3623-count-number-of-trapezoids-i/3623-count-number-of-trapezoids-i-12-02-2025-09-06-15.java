class Solution {
    public int countTrapezoids(int[][] points) {
        long count = 0;
        int MOD = 1000000007;
        Map<Integer, Integer> yCount = new HashMap<>();

        for (int[] point : points) {
            int y = point[1];
            yCount.put(y, yCount.getOrDefault(y, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(yCount.values());
        
        long totalPairs = 0;
        long sumOfPairs = 0;

        for (int cnt : counts) {
            if (cnt >= 2) {
                long pairs = (long) cnt * (cnt - 1) / 2;
                count = (count + (sumOfPairs * pairs)) % MOD;
                sumOfPairs = (sumOfPairs + pairs) % MOD;
            }
        }
        
        return (int) count;
    }
}