class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for(int x : nums){
            while(!stack.isEmpty() && stack.peek() > x){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek() < x){
                ans++;
                stack.push(x);
            }
        }
        return ans;
    }
}