class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
            minDiff = Math.min(minDiff, arr[i]- arr[i - 1]);
        }

        List<List<Integer>> li = new ArrayList<>();
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i - 1] == minDiff){
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                li.add(pair);
            }
        }
        return li;
    }
}