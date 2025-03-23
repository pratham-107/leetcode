class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int index = 0;
        HashMap<Integer, Integer> m =new HashMap<>();

        for(int x : arr1){
            m.put(x, m.getOrDefault(x,0) + 1);
        }

        for(int x : arr2){
            int cnt = m.getOrDefault(x, 0);
            for(int i=0; i<cnt; i++){
                result[index++] = x;
            }
            m.remove(x);
        }

        List<Integer> rem = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : m.entrySet()){
            int x = e.getKey();
            int cnt = e.getValue();
            for(int i=0; i<cnt; i++){
                rem.add(x);
            }
        }
        rem.sort(null);
        for(int x : rem){
            result[index++] = x;
        }
        return result;
    }
}