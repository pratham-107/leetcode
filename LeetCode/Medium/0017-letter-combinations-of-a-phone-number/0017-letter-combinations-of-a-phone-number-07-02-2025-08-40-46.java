class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }

        List<String> ans  = new ArrayList<>();
        ans.add("");
        String[] digitToLetters = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        for(char x : digits.toCharArray()){
            List<String> temp = new ArrayList<>();
                for(String s : ans){
                    for(char c : digitToLetters[x - '0'].toCharArray()){
                        temp.add(s + c);
                    }
                }
                ans = temp;
        }
        return ans;
    }
}