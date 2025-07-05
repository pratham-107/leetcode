class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int j = 0; j < p.length(); j++){
            if(p.charAt(j) == '*'){
                dp[0][j + 1] = dp[0][j];
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(p.charAt(j) == '*'){
                    boolean matchEmpty = dp[i + 1][j];
                    boolean matchSome = dp[i][j + 1];
                    dp[i + 1][j + 1] = matchEmpty || matchSome;
                }
                else if(isMatch(s, i, p, j)){
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[m][n];
    }
    
    private boolean isMatch(String s, int i, String p, int j){
        return j >= 0 && p.charAt(j) == '?' || s.charAt(i) == p.charAt(j); 
    }
}