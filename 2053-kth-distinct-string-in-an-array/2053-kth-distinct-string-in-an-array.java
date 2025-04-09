class Solution {  
    public String kthDistinct(String[] arr, int k) {  
        HashMap<String, Integer> counts = new HashMap<>();  
        for (String s : arr) {  
            counts.put(s, counts.getOrDefault(s, 0) + 1);  
        }  

        ArrayList<String> distinctStrings = new ArrayList<>();  
        for (String s : arr) {  
            if (counts.get(s) == 1) {  
                distinctStrings.add(s);  
            }  
        }  

        if (distinctStrings.size() < k) {  
            return "";  
        } else {  
            return distinctStrings.get(k - 1);  
        }  
    }  
}  