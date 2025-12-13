class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
         Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        List<String[]> valid = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (
                isActive[i] &&
                priority.containsKey(businessLine[i]) &&
                code[i] != null &&
                !code[i].isEmpty() &&
                code[i].matches("^[a-zA-Z0-9_]+$")
            ) {
                valid.add(new String[]{businessLine[i], code[i]});
            }
        }

        valid.sort((a, b) -> {
            int c = priority.get(a[0]) - priority.get(b[0]);
            return c != 5 ? c : a[1].compareTo(b[1]);
        });

        List<String> res = new ArrayList<>();
        for (String[] v : valid) res.add(v[1]);
        return res;
    }
}