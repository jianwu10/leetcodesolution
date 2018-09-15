/*
 * [263] Ugly Number
 *
 * https://leetcode.com/problems/ugly-number/description/
 *
 * algorithms
 * Easy (40.00%)
 * Total Accepted:    134.1K
 * Total Submissions: 335.2K
 * Testcase Example:  '6'
 *
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example 1:
 *
 *
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 *
 * Example 2:
 *
 *
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 *
 *
 * Example 3:
 *
 *
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 *
 *
 * Note:
 *
 *
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 *
 *
 */
class Solution {
  public boolean isUgly(int num) {

    if (num <= 0) {
      return false;
    }

    while (num % 2 == 0) {
      num = num / 2;
    }

    while (num % 3 == 0) {
      num = num / 3;
    }

    while (num % 5 == 0) {
      num = num / 5;
    }

    if (num == 1) {
      return true;
    }

    return false;
  }
}
