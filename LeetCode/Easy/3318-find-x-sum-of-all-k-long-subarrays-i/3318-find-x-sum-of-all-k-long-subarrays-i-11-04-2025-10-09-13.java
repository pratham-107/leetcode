class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];

        for(int i = 0; i <= n - k; i++){
            int[] subarray = Arrays.copyOfRange(nums,i ,i + k);
            answer[i] = xSum(subarray, x);
        }
        return answer;
    }

    private int xSum(int[] subarray, int x){
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int num : subarray){
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedCount = new ArrayList<>(cnt.entrySet());
        sortedCount.sort((a,b) -> {
            if(a.getValue().equals(b.getValue())){
                return b.getKey() - a.getKey();
            }
            return b.getValue() - a.getValue();
        });

        int sum = 0;
        int count = 0;
        Set<Integer> topX = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : sortedCount){
            if(count < x){
                topX.add(entry.getKey());
                count++;
            }
        }
        for(int num : subarray){
            if(topX.contains(num)){
                sum += num;
            }
        }
        return sum;
    }
}