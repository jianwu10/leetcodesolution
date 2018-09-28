/*
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (26.60%)
 * Total Accepted:    244.7K
 * Total Submissions: 920K
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 *
 * Example 2:
 *
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 *
 * Example 3:
 *
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * Note:
 *
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 *
 *
 */
class Solution {
  public double myPow(double x, int n) {
    // if n == 0
    if (n == 0) {
      return 1;
    }
    // if x == 0
    if (Math.abs(x) < 1E-15) {
      return 0;
    }

    double result = 1;
    double base = x;
    long power = n;
    if (power < 0) {
      power = -power;
      base = 1 / base;
    }

    while (power != 0) {
      if (power % 2 == 1) {
        result *= base;
      }
      power /= 2;
      base = base * base;
    }
    return result;
  }
}
