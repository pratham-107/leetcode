class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        int sumB =0;

        HashMap<Integer, Integer> m = new HashMap<>();
        for(int x : aliceSizes){
            sumA += x;
        }
        for(int y : bobSizes){
            sumB += y;
            m.put(y, 1);
        }

        int diff = (sumB - sumA) / 2;

        for(int x : aliceSizes){
            if(m.containsKey(x + diff)){
                return new int[]{x, x + diff};
            }
        }
        return new int[0];
    }
}