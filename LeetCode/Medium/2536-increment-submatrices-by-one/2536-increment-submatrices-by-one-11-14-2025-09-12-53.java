class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];
        int[][] prefix = new int[n][n + 1];

        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            for (int i = row1; i <= row2; i++) {
                prefix[i][col1]++;
                prefix[i][col2 + 1]--;
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += prefix[i][j];
                ans[i][j] = sum;
            }
        }

        return ans;
    }
}