//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//sol 1 complexity: nlogn
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s1= s.toCharArray();
        Arrays.sort(s1);
        char[] s2= t.toCharArray();
        Arrays.sort(s2);
        boolean result = Arrays.equals(s1,s2) ? true : false;
        return result;

    }
}

//sol 2 complexity n
class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length()) return false;
       int[] counter = new int[26];
       for(int i =0; i< s.length(); i++) {
           counter[s.charAt(i) - 'a']++;
           counter[t.charAt(i) - 'a']--;
       }
       for(int count: counter) {
           if(count != 0 ) return false;
       }
       return true;
    }
}

//Input: s = "anagram", t = "nagaram"
//Output: true
