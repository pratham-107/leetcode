class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap <Integer, Integer> m = new HashMap <>();
        ArrayList <Integer> li = new ArrayList<>();

        for(int x : nums){
            m.put(x, m.getOrDefault(x, 0) + 1);
            li.add(x);
        }
        Collections.sort(li, (a,b) -> (m.get(a) == m.get(b)) ? b-a : m.get(a) - m.get(b));

        for(int i=0; i<nums.length; i++){
            nums[i] = li.get(i);
        }
        return nums;
    }
}