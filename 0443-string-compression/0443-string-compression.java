class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int i =0;
        int n = chars.length;

        while(i < n){
            char curr = chars[i];
            int count = 0;

            while(i < n && chars[i] == curr){
                count++;
                i++;
            }
            chars[index++] = curr;

            if(count > 1){
                String countstr = String.valueOf(count);
                for(char c : countstr.toCharArray()){
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}