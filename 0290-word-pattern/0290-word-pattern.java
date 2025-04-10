class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> m1 = new HashMap<>();
        HashMap<String, Character> m2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String x = words[i];

            if (!m1.containsKey(c)) {
                m1.put(c, x);
            } else {
                if (!m1.get(c).equals(x)) {
                    return false;
                }
            }

            if (!m2.containsKey(x)) {
                m2.put(x, c);
            } else {
                if (!m2.get(x).equals(c)) {
                    return false;
                }
            }
        }

        return true;
    }
}