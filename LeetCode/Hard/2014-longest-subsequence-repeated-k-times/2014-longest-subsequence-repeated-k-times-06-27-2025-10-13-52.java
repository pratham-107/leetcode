import java.util.*;

class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        String ans = "";
        int[] count = new int[26];
        List<Character> li = new ArrayList<Character>();
        Queue<String> q = new ArrayDeque<String>();
        q.offer("");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a'] = count[c - 'a'] + 1;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] >= k) {
                li.add(c);
            }
        }

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.length() * k > s.length()) {
                return ans;
            }
            for (char c : li) {
                String newSubq = curr + c;
                if (isSubsequence(newSubq, s, k)) {
                    q.offer(newSubq);
                    ans = newSubq;
                }
            }
        }
        return ans;
    }

    private boolean isSubsequence(String subq, String s, int k) {
        int i = 0;
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            char x = s.charAt(j);
            if (x == subq.charAt(i)) {
                i = i + 1;
                if (i == subq.length()) {
                    count = count + 1;
                    if (count == k) {
                        return true;
                    }
                    i = 0;
                }
            }
        }
        return false;
    }
}
