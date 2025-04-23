class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, (a,b) -> (b+a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for(String x : s){
            sb.append(x);
        }

        String ans = sb.toString();

        if(ans.charAt(0) == '0' && ans.length() > 1){
            int i =0;
            while(i < ans.length() -1 && ans.charAt(i) == '0'){
                i++;
            }
            if(i == ans.length() - 1 && ans.charAt(i) == '0')
            return "0";

            return ans.substring(i);
        }
        if(ans.charAt(0) == '0' && ans.length() == 1){
            return "0";
        }
        return ans;
    }
}