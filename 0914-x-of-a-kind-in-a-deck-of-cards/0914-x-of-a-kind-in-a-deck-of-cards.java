class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck == null || deck.length < 2){
            return false;
        }

        int[] count = new int[10000];
        for(int x : deck){
            count[x]++;
        }

        int gcd = 0;
        for(int y : count){
            if(y > 0){
                if(gcd == 0){
                    gcd = y;
                }
                else{
                    gcd = gcd(gcd, y);
                }
            }
        }
        return gcd > 1;
    }
    private int gcd(int a , int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}