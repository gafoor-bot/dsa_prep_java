import java.util.HashMap;
//Link: https://neetcode.io/problems/is-anagram/question
class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // HashMap to store character frequencies of string s
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character in s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Increment count if character already exists
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                // FIX: should start from 1, not 0
                map.put(ch, 1);
            }
        }

        // Decrease frequency using characters from t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            // If character not found, not an anagram
            if (!map.containsKey(ch)) {
                return false;
            }

            // Decrease the count
            map.put(ch, map.get(ch) - 1);

            // If count goes below 0, extra character exists in t
            if (map.get(ch) < 0) {
                return false;
            }
        }

        // If all counts match, strings are anagrams
        return true;
    }
}

/*
Time Complexity:
O(n) - We traverse both strings once.

Space Complexity:
O(1) - At most 26 characters stored (assuming lowercase English letters),
otherwise O(n) in general.
*/