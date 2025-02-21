class Solution {
    public int maxLength(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            int p =nums[i], gcd =nums[i], lcm = nums[i];

            for(int j=i+1; j<nums.length; j++){
                p *= nums[j];
                gcd = GCD(gcd, nums[j]);
                lcm = LCM(lcm, nums[j]);

                if(p == gcd * lcm) ans = Math.max(ans, j-i+1);
            }
        }
        return ans;
    }
    public int GCD(int a, int b){
        return b == 0 ? a : GCD(b, a%b);
    }
    public int LCM(int a, int b){
        return (a*b) / GCD(a,b);
    }
}