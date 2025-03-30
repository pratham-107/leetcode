class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] ans = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                 ans[i][j] = matrix[i][j];
            }
        }
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    for(int k=0; k<m; k++){
                        ans[i][k] = 0;
                    }
                    for(int k=0; k<n; k++){
                        ans[k][j] = 0;
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = ans[i][j];
            }
        }
    }
}