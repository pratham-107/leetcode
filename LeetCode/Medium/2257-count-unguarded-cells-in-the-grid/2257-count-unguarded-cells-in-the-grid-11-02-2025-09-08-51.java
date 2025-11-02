class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        boolean[][] grid = new boolean[m][n]; 

        int[][] wallGrid = new int[m][n];
        for (int[] wall : walls) {
            wallGrid[wall[0]][wall[1]] = -1;
        }
        for (int[] guard : guards) {
            wallGrid[guard[0]][guard[1]] = -2;
        }
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];

            for (int i = row - 1; i >= 0; i--) {
                if (wallGrid[i][col] != 0) {
                    break;
                }
                grid[i][col] = true;
            }
            for (int i = row + 1; i < m; i++) {
                if (wallGrid[i][col] != 0) {
                    break;
                }
                grid[i][col] = true;
            }
            for (int j = col - 1; j >= 0; j--) {
                if (wallGrid[row][j] != 0) {
                    break;
                }
                grid[row][j] = true;
            }
            for (int j = col + 1; j < n; j++) {
                if (wallGrid[row][j] != 0) {
                    break;
                }
                grid[row][j] = true;
            }
        }
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!grid[i][j] && wallGrid[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }
}