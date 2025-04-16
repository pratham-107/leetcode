class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> m = new HashMap<>();

        for(int i=0; i<nums2.length; i++){
            int curr = nums2[i];

            for(int j=i+1; j<nums2.length; j++){
                if(nums2[j] > curr){
                    m.put(curr, nums2[j]);
                    break;
                }
            }
            if(!m.containsKey(curr)){
                m.put(curr, -1);
            }
        }
        for(int i=0; i<nums1.length; i++){
            ans[i] = m.get(nums1[i]);
        }
        return ans;
    }
}