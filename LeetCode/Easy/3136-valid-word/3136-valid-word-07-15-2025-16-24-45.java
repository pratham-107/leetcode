class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3){
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for(int i = 0; i< word.length(); i++){
            char c = word.charAt(i);
            if(!Character.isLetterOrDigit(c)){
                return false;
            }

            if(Character.isLetter(c)){
                char lowerC = Character.toLowerCase(c);
                if (lowerC == 'a' || lowerC == 'e' || lowerC == 'i' || lowerC == 'o' || lowerC == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }
        return hasVowel && hasConsonant;
    }
}