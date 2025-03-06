class Solution {
    private void dfs(int node, int[][] isConnected, boolean[] vis){
        vis[node] = true;
        for(int j=0; j<isConnected.length; j++){
            if(isConnected[node][j] == 1 && !vis[j]){
                dfs(j, isConnected, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
            if(!vis[i]){
                count++;
                dfs(i, isConnected, vis);
            }
        }
        return count;
    }
}