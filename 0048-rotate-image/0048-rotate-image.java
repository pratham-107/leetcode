class Solution {
    public void rotate(int[][] matrix) {
        for(int i =0; i<matrix.length; i++){
            for(int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int k=0; k<matrix.length; k++){
            int i =0;
            int j = matrix[k].length - 1;
            while(i < j){
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
                i++;
                j--;
            }
        }
    }
}