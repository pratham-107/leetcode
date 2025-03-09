class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<baskets.length;j++){
                if(baskets[j]>=fruits[i]){
                    baskets[j]=-1;
                    fruits[i]=-1;
                    break;
                }
            }
        }
        int ans=0;
        for(int x:fruits){
            if(x!=-1) ans++;
        }
        return ans;
    }    
}