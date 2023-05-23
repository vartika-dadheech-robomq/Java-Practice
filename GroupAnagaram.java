//Given an array of strings strs, group the anagrams together. You can return the answer in any order.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> anagram = new HashMap<>();
        for(int i=0; i< strs.length; i++) {
            char [] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            String s = new String(sorted);
            if(!anagram.containsKey(s)) {
                anagram.put(s, new ArrayList<String>());
            }
            anagram.get(s).add(strs[i]); 
    }     
            return new ArrayList(anagram.values());
}
               }

//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]