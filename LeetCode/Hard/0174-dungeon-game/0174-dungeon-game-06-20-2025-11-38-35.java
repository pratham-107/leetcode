class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] ans = new int[m + 1][n + 1];
        Arrays.stream(ans).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE));
        ans[m][n - 1] = 1;
        ans[m - 1][n] = 1;

        for(int i = m - 1; i >= 0; i--){
          for(int j = n - 1; j >= 0; j--){
            ans[i][j] = Math.min(ans[i + 1][j], ans[i][j + 1]) - dungeon[i][j];
            ans[i][j] = Math.max(ans[i][j], 1);
          }
        }
        return ans[0][0];
    }
}