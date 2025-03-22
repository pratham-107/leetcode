class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int count = n / 2;

        HashMap<Integer, Integer> m = new HashMap<>();
        for(int x : candyType){
            m.put(x, m.getOrDefault(x, 0) + 1);
        }

        int unq = m.size();
        return Math.min(unq, count);
    }
}