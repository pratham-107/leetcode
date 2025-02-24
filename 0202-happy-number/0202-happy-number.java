class Solution {
    public boolean isHappy(int n) {
        int d1 = squaredSum(n);
        int d2 = squaredSum(squaredSum(n));
        while(d1 != d2){
            d1 = squaredSum(d1);
            d2 = squaredSum(squaredSum(d2));
        }
        return d1 == 1;
    }
    private int squaredSum(int n){
        int sum = 0;
        while(n > 0){
            sum += Math.pow(n % 10 , 2);
            n /= 10;
        }
        return sum;
    }
}