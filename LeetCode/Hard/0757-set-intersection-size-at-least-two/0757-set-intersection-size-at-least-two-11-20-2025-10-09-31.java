class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int ans = 0;
        int mx = -1;
        int secondMax = -1;

        Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[1]).thenComparingInt((int[] interval) -> - interval[0]));

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];

            if(mx >= start && secondMax >= start) continue;
            if(mx >= start){
                secondMax = mx;
                mx = end;
                ans += 1;
            }
            else{
                mx = end;
                secondMax = end - 1;
                ans += 2;
            }
        }
        return ans;
    }
}