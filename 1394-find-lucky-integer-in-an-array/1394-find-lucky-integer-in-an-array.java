class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[arr.length + 1];

        for(int x : arr){
            if(x <= arr.length){
                count[x]++;
            }
        }
        for(int i=arr.length; i>=1; i--){
            if(count[i] == i){
                return i;
            }
        }
        return -1;
    }
}