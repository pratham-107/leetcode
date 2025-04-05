class Solution {
    public int bestClosingTime(String customers) {
        int ans = 0;
        int profit = 0;
        int max = 0;

        for(int i=0; i<customers.length(); i++){
            if(customers.charAt(i) == 'Y'){
                profit += 1;
            }
            else{
                profit -= 1;
            }
            if(profit > max){
                max = profit;
                ans = i+1;
            }
        }
        return ans;
    }
}