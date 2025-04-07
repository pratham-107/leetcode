class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                word.append(ch);
            } else {
                if (word.length() > 0) {
                    if (ans.length() > 0) {
                        ans.insert(0, " ");
                    }
                    ans.insert(0, word);
                    word.setLength(0);
                }
            }
        }
        
        // Add the last word if it exists
        if (word.length() > 0) {
            if (ans.length() > 0) {
                ans.insert(0, " ");
            }
            ans.insert(0, word);
        }
        
        return ans.toString();
    }
}