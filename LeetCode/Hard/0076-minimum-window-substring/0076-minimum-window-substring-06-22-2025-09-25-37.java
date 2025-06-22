class Solution {
    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        int req = t.length();
        int bl = -1;
        int min = s.length() + 1;

        for(char c : t.toCharArray()){
          cnt[c]++;
        }

        for(int l = 0, r = 0; r < s.length(); r++){
          if(--cnt[s.charAt(r)] >= 0){
            req--;
          }
          while(req == 0){
            if(r - l + 1 < min){
              bl = l;
              min = r - l + 1;
            }
            if(++cnt[s.charAt(l++)] > 0){
              req++;
            }
          }
        }
        return bl == -1 ? "" : s.substring(bl, bl + min);
    }
}