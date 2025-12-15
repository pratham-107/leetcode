class Solution {
    public int fib(int n) {
       for(int x : n){
         if(n <= 1){
            return n;
        }
        int last = n - 1;
        int slast = n - 2;
        return last + slast;
       }
    }
}