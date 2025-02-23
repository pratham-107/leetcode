class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] hash = new int[101];

        for(int x : nums){
            hash[x]++;
        }

        int max = Arrays.stream(hash).max().getAsInt();

        int count = 0;
        for(int i=0; i<101; i++){
            if(hash[i] == max) count++;   
        }
        return count * max;
    }
}