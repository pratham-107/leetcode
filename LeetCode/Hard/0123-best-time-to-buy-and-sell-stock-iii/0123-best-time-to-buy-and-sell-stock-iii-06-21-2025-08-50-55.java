class Solution {
    public int maxProfit(int[] prices) {
        int sellTwo = 0;
        int holdTwo = Integer.MIN_VALUE;
        int sellOne = 0;
        int holdOne = Integer.MIN_VALUE;

        for(int x : prices){
          sellTwo = Math.max(sellTwo, holdTwo + x);
          holdTwo = Math.max(holdTwo, sellOne - x);
          sellOne = Math.max(sellOne, holdOne + x);
          holdOne = Math.max(holdOne, - x);
        }
        return sellTwo;
    }
}