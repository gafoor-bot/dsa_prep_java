import java.util.*;
//Link: https://neetcode.io/problems/anagram-groups/question
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store grouped anagrams
        // Key: character frequency representation
        // Value: list of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // Traverse each string in the input array
        for (String str : strs) {
            // Count frequency of each character (assuming lowercase letters)
            int[] count = new int[26];

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // Convert count array to string to use as key
            String key = Arrays.toString(count);

            // Add string to corresponding anagram group
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}

/*
Time Complexity:
O(n * k)
- n = number of strings
- k = maximum length of a string
We iterate through each string and count characters (O(k)).

Space Complexity:
O(n * k)
- Storing all strings in the HashMap and result list.
- Count array takes O(1) space (fixed size 26).
*/