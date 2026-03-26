//Link: https://neetcode.io/problems/products-of-array-discluding-self/question
class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;

        // Prefix array where prefix[i] contains product of all elements before index i
        int[] prefix = new int[n];
        prefix[0] = 1; // No elements to the left of first index

        // Time: O(n)
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        // Suffix array where suffix[i] contains product of all elements after index i
        int[] suffix = new int[n];
        suffix[n - 1] = 1; // No elements to the right of last index

        // Time: O(n)
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        // Final product array
        int[] product = new int[n];

        // Time: O(n)
        for (int i = 0; i < n; i++) {
            product[i] = prefix[i] * suffix[i];
        }

        return product;
    }
}

/*
----------------------------------------
Time Complexity:
----------------------------------------
- Prefix computation: O(n)
- Suffix computation: O(n)
- Final multiplication: O(n)

Total Time Complexity: O(n)

----------------------------------------
Space Complexity:
----------------------------------------
- Prefix array: O(n)
- Suffix array: O(n)
- Output array: O(n)

Total Space Complexity: O(n)

Note:
Space can be optimized to O(1) (excluding output array) by avoiding
extra prefix and suffix arrays.
*/