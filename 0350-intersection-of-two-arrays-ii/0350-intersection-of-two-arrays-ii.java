class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int x : nums1){
            m.put(x, m.getOrDefault(x,0) + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int x : nums2){
            if(m.getOrDefault(x, 0) > 0){
                ans.add(x);
                m.put(x, m.get(x) -1);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}