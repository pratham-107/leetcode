class Solution {
    public int islandPerimeter(int[][] grid) {
        int n= grid.length;
        int perimeter = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    if(i == 0 || grid[i-1][j] == 0) perimeter++;
                    if(i == n-1 || grid[i+1][j] == 0) perimeter++;
                    if(j == 0 || grid[i][j-1] == 0) perimeter++;
                    if(j == grid[i].length - 1 || grid[i][j+1] == 0) perimeter++;
                }
            }
        }
        return perimeter;
    }
}