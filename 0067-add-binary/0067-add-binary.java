class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while(i >= 0 || j >= 0 || count == 1){
            if(i >= 0){
                count += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                count += b.charAt(j) - '0';
                j--;
            }
            sb.append(count % 2);
            count /= 2;
        }
        return sb.reverse().toString();
    }
}