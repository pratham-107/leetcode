class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> set = new HashSet<>();
        Arrays.sort(digits);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(i != j && i != k && j != k) {
                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if(num >= 100 && num % 2 == 0) {
                            set.add(num);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}