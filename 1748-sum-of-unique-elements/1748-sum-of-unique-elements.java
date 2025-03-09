class Solution {
    public int sumOfUnique(int[] nums) {
        int[] hash = new int[101];
        int sum = 0;
        for(int x : nums) hash[x]++;

        for(int i=0; i<101; i++){
            if(hash[i] == 1){
                sum += i;
            }
        }
        return sum;
    }
}