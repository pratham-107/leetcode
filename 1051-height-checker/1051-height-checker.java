class Solution {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] arr = Arrays.stream(heights).sorted().toArray();

        for(int i=0; i<arr.length; i++){
            if(heights[i] != arr[i]){
                count++;
            }
        }
        return count;
    }
}