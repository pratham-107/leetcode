class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        int prevEven = 0;
        int prevOdd = 0;

        for(int i=0; i<arr.length; i++){
            int currEven = prevOdd + ((i+1) / 2) * arr[i];
            int currOdd = prevEven + (i / 2 + 1) * arr[i];
            ans += currOdd;
            prevEven = currEven;
            prevOdd = currOdd;
        }
        return ans;
    }
}