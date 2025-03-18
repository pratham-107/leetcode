class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        HashMap <Character, Integer> m = new HashMap <> ();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(!m.containsKey(c)){
                m.put(c,i);
            }
            else{
                m.put(c,n);
            }
        }
        int ans = n;
        for(int x : m.values()){
            ans = Math.min(ans, x);
        }
        
        return ans == n ? -1 : ans;
    }
}