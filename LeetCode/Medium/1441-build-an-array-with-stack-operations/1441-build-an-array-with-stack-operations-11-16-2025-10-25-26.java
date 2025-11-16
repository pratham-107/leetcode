class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operation = new ArrayList<>();
        int curr = 1;
        int targetIndex = 0;

        while(targetIndex < target.length){
            if(curr == target[targetIndex]){
                operation.add("Push");
                targetIndex++;
            }
            else{
                operation.add("Push");
                operation.add("Pop");
            }
            curr++;
        }
        return operation;
    }
}