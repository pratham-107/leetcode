class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalCost = 0;
        int i = 0;

        while(i < colors.length() - 1){
            if(colors.charAt(i) == colors.charAt(i + 1)){
                int j = i;
                int maxTime = 0;
                int currCost = 0;
                int sum = 0;
                
                while(j < colors.length() && colors.charAt(i) == colors.charAt(j)){
                    maxTime = Math.max(maxTime, neededTime[j]);
                    sum += neededTime[j];
                    j++;
                }
                totalCost += sum - maxTime;
                i = j;
            } else {
                i++;
            }
        }
        return totalCost;
    }
}