package org.lld.machinecoding;

import java.util.HashMap;
import java.util.Map;

/**
 * Finds the length of the longest substring that has no repeated characters.
 *
 * <p>Example: for "pwwkew" the answer is 3 ("wke" or "kew"). "pwke" is not a
 * valid answer because it is a subsequence, not a contiguous substring.
 *
 * <p>Approach: keep a "sliding window" [windowStartIndex, i] that
 * always contains only unique characters. The window grows one character at a
 * time on the right; if the new character is already in the window, the left
 * edge jumps to just after that character's previous position.
 */
public class LongestSubstringWithoutRepeatedChar {

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(
                "Length of longest substring without repeating characters: "
                        + lengthOfLongestSubstring(input)); // Output: 2
    }

    // O(n) time and O(k) space, where k is the number of distinct characters.
    static int lengthOfLongestSubstring(String input) {
        // Maps each character to the index where it was most recently seen.
        // We store the index (not just a boolean) so that when a duplicate appears,
        // the window can jump directly past the previous occurrence instead of
        // shrinking one character at a time.
        Map<Character, Integer> lastSeenIndexByCharacter = new HashMap<>();

        int longestLength = 0;
        int windowStartIndex = 0; // Left edge of the current duplicate-free window.

        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);

            Integer previousIndex = lastSeenIndexByCharacter.get(currentCharacter);
            if (previousIndex != null) {
                // The current character repeats. Move the left edge to one position
                // after its previous occurrence so the window becomes unique again.
                // Math.max is needed because that occurrence may already be outside
                // the current window; without it, the window could move backwards
                // (for example, "abba": when the last 'a' is processed, we must not
                // move the start back from index 2 to index 1).
                windowStartIndex = Math.max(windowStartIndex, previousIndex + 1);
            }

            // The window is now guaranteed to be duplicate-free, so compare its
            // length with the best answer found so far.
            int currentWindowLength = i - windowStartIndex + 1;
            longestLength = Math.max(longestLength, currentWindowLength);

            // Remember this character's position so a future duplicate can skip
            // directly past it.
            lastSeenIndexByCharacter.put(currentCharacter, i);
        }

        return longestLength;
    }
}

/*
 * Iteration-by-iteration trace for the input used in main: "abba"
 * ----------------------------------------------------------------
 * Initial state: windowStartIndex (start) = 0, longestLength (max length) = 0
 *
 * i | char | previousIndex | start | window length | max length | current window
 * --+------+---------------+-------+---------------+------------+----------------
 * 0 |  a   | null          |   0   |       1       |     1      | "a"
 * 1 |  b   | null          |   0   |       2       |     2      | "ab"
 * 2 |  b   | 1             |   2   |       1       |     2      | "b"
 * 3 |  a   | 0             |   2   |       2       |     2      | "ba"
 *
 * Final answer: 2 ("ab" or "ba" are the longest substrings without repeats).
 *
 * How to read a row:
 *   i              = current index / right edge of the window
 *   previousIndex  = last index where the current character was seen, if any
 *   start          = windowStartIndex after the duplicate check
 *   window length  = i - start + 1
 *   max length     = longestLength after this iteration
 *
 * Why the last row matters:
 *   For i = 3, the previous 'a' is at index 0, so previousIndex + 1 = 1.
 *   However, start is already 2, so Math.max(2, 1) keeps start at 2.
 *   Without Math.max, the window would incorrectly move backwards to index 1.
 */


