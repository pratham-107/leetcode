class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = build(n);
        return  result.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> build(int n){
        if(n == 1){
            return Arrays.asList(1);
        }

        List<Integer> l = build((n + 1) / 2);
        List<Integer> r = build(n / 2);

        List<Integer> ans = new ArrayList<>();
        for(int x : l){
            ans.add(2 * x - 1);
        }
        for(int x : r){
            ans.add(2 * x);
        }
        return ans;
    }
}