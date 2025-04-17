class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";

        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }
    private int gcd(int i, int j){
        while(j != 0){
            int temp = j;
            j = i % j;
            i = temp;
        }
        return i;
    }
}