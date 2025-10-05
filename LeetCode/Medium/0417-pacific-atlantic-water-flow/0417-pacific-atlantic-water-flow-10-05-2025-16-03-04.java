class Solution {
    private int[][] heights;
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;

        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachPacific);
            dfs(i, n - 1, canReachAtlantic);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, canReachPacific);
            dfs(m - 1, j, canReachAtlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] reachable) {
        if (reachable[row][col]) {
            return;
        }

        reachable[row][col] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, reachable);
            }
        }
    }
}