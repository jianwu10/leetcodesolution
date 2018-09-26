/*
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (25.03%)
 * Total Accepted:    585.8K
 * Total Submissions: 2.3M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 *
 * Example 1:
 *
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 *
 * Example 3:
 *
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 *
 *
 *
 *
 *
 */

 // Two pointers + HashMap

class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    }
    if (s.length() <= 1) {
      return s.length();
    }

    int left = 0;
    int right = 1;
    int longest = 0;
    Map<Character, Integer> map = new HashMap<>();
    map.put(s.charAt(0), 0);

    for (right = 1; right < s.length(); right++) {
      if (map.containsKey(s.charAt(right))) {
        // found a duplicate character
        longest = Math.max(longest, right - left);
        // update left
        while (s.charAt(left) != s.charAt(right)) {
          map.remove(s.charAt(left));
          left++;
        }
        left++;
      }
      map.put(s.charAt(right), right);
    }
    longest = Math.max(longest, right - left);
    return longest;
  }
}
