class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;

        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[] { heightMap[i][j], i, j });
                    visited[i][j] = true;
                }
            }
        }
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int result = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int height = curr[0];
            int row = curr[1];
            int col = curr[2];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                        !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;

                    int neighborHeight = heightMap[newRow][newCol];
                    if (neighborHeight < height) {
                        result += height - neighborHeight;
                    }
                    pq.offer(new int[] {
                            Math.max(neighborHeight, height), newRow, newCol
                    });
                }
            }
        }
        return result;
    }
}