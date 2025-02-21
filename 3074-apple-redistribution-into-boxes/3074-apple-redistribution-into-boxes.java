class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        int i = capacity.length - 1;
        int box = 0;
        
        while(sum > 0){
            sum -= capacity[i--];
            box++;
        }
        return box;
    }
}