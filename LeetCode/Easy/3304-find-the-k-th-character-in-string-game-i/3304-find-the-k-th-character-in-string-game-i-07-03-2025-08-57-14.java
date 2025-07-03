class Solution {
    public char kthCharacter(int k) {
        int numb = k - 1;
        int cnt = cntBits(numb);
        char result = (char) ('a' + cnt);
        return result;
    }
    private int cntBits(int num){
        int cnt = 0;
        while(num > 0){
            if((num & 1) == 1){
                cnt++;
            }
            num = num >> 1;
        }
        return cnt;
    }
}