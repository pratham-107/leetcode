class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int x : arr){
            m.put(x, m.getOrDefault(x, 0) + 1);
        }

        Set<Integer> s = new HashSet<>();
        for(int x : m.values()){
            if(!s.add(x)) return false;
        }
        return true;
    }
}