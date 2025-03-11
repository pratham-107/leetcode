class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int x : cardPoints){
            sum += x;
        }

        if(k == n){
            return sum;
        }

        int windowsize = n - k;
        int ans = 0;

        for(int i=0 ; i<windowsize; i++){
            ans  += cardPoints[i];
        }

        int minsum = ans;
        for(int i=windowsize; i<n; i++){
            ans += cardPoints[i] - cardPoints[i - windowsize];
            minsum = Math.min(minsum, ans);
        }
        return sum - minsum;
    }
}