class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap <Integer, String> m = new HashMap <> ();

        for(int i=0; i<heights.length; i++){
            m.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        for(int i= heights.length - 1, j =0; i>=0; i--, j++){
            names[j] = m.get(heights[i]);
        }
        return names;
    }
}