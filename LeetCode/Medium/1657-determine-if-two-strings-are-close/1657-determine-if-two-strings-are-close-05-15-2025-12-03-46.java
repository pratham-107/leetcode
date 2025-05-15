class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for(char c : word1.toCharArray()){
            m1.merge(c, 1, Integer::sum);
        }

        for(char c : word2.toCharArray()){
            m2.merge(c, 1, Integer::sum);
        }

        if(!m1.keySet().equals(m2.keySet())) return false;

        List<Integer> l1 = new ArrayList<>(m1.values());
        List<Integer> l2 = new ArrayList<>(m2.values());

        Collections.sort(l1);
        Collections.sort(l2);

        return l1.equals(l2);
    }
}