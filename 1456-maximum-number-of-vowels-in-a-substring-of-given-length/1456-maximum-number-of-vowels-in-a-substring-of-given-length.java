class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int max = 0;
        int current = 0;

        for(int i=0; i<k; i++){
            if(isVowel(s.charAt(i))){
                current++;
            }
        }
        max = current;

        for(int i=k; i<n; i++){
            if(isVowel(s.charAt(i))){
                current++;
            }
            if(isVowel(s.charAt(i-k))){
                current--;
            }
            max = Math.max(max, current);
        }
        return max;
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}