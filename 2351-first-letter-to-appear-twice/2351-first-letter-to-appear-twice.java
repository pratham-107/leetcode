class Solution {
    public char repeatedCharacter(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            freq[index]++;
            if (freq[index] == 2) {
                return ch;
            }
        }
        return ' ';
    }
}
