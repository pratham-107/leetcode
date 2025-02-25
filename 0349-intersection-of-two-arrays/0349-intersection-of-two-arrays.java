class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hash = new int[1001];
        int count = 0;

        for(int x : nums1){
            hash[x] = 1;
        }

        for(int x : nums2){
            if(hash[x] == 1){
                hash[x] = 2;
                count++;
            }
        }

        int[] result = new int[count];
        int ans = 0;

    for(int i=0; i<1001; i++){
        if(hash[i] == 2){
            result[ans++] = i;
        }
    }
    return result;
    }
}