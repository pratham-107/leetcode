class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = getGaps(eventTime, startTime, endTime);
        int ans = 0;

        int[] maxLeft = new int[n + 1];
        int[] maxRight = new int[n + 1];

        maxLeft[0] = gaps[0];
        for (int i = 1; i < n + 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], gaps[i]);
        }
        maxRight[n] = gaps[n];
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], gaps[i]);
        }

        for (int i = 0; i < n; i++) {
            int currMeetingTime = endTime[i] - startTime[i];
            int adjacentGapsSum = gaps[i] + gaps[i + 1];

            int maxOtherGap = Math.max(
                    i > 0 ? maxLeft[i - 1] : 0,
                    i + 2 < n + 1 ? maxRight[i + 2] : 0);

            ans = Math.max(ans, adjacentGapsSum);

            if (currMeetingTime <= maxOtherGap) {
                ans = Math.max(ans, adjacentGapsSum + currMeetingTime);
            }
        }
        return ans;
    }

    private int[] getGaps(int eventTime, int[] startTime, int[] endTime) {
        int[] gaps = new int[startTime.length + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < startTime.length; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[startTime.length] = eventTime - endTime[endTime.length - 1];
        return gaps;
    }
}
