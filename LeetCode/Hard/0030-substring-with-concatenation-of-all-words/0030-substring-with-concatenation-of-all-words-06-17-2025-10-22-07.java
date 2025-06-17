class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    if (s == null || s.length() == 0 || words == null || words.length == 0)
      return result;

    int wordLen = words[0].length();
    int wordCount = words.length;
    int totalLen = wordLen * wordCount;

    Map<String, Integer> wordMap = new HashMap<>();
    for (String word : words)
      wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);

    for (int i = 0; i < wordLen; i++) {
      int left = i, right = i, count = 0;
      Map<String, Integer> windowMap = new HashMap<>();

      while (right + wordLen <= s.length()) {
        String word = s.substring(right, right + wordLen);
        right += wordLen;

        if (wordMap.containsKey(word)) {
          windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
          count++;

          while (windowMap.get(word) > wordMap.get(word)) {
            String leftWord = s.substring(left, left + wordLen);
            windowMap.put(leftWord, windowMap.get(leftWord) - 1);
            left += wordLen;
            count--;
          }

          if (count == wordCount)
            result.add(left);
        } else {
          windowMap.clear();
          count = 0;
          left = right;
        }
      }
    }

    return result;
  }
}
