class Solution {
    public char kthCharacter(long k, int[] operations) {
        int operationCount = (int) Math.ceil(Math.log(k) / Math.log(2));
        int inc = 0;

        for(int i = operationCount - 1; i >= 0; i--){
            long halfSize = 1L << i;
            if(k > halfSize){
                k -= halfSize;
                inc += operations[i];
            }
        }
        return (char) ('a' + inc % 26);
    }
}