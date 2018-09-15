/*
 * [264] Ugly Number II
 *
 * https://leetcode.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (34.17%)
 * Total Accepted:    84.4K
 * Total Submissions: 247K
 * Testcase Example:  '10'
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
 * 5. 
 *
 * Example:
 *
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 *
 * Note:  
 *
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 *
 *
 */
class Solution {
  public int nthUglyNumber(int n) {
    long[] primes = new long[3];
    primes[0] = Long.valueOf(2);
    primes[1] = Long.valueOf(3);
    primes[2] = Long.valueOf(5);

    Queue<Long> minHeap = new PriorityQueue<>();
    Set<Long> set = new HashSet<>();

    minHeap.offer(Long.valueOf(1));
    set.add(Long.valueOf(1));

    Long uglyNumber = Long.valueOf(1);

    for (int i = 1; i <= n; i++) {
      uglyNumber = minHeap.poll();

      for (int j = 0; j < 3; j++) {
        if (!set.contains(uglyNumber * primes[j])) {
          minHeap.offer(uglyNumber * primes[j]);
          set.add(uglyNumber * primes[j]);
        }
      }
    }

    return uglyNumber.intValue();
  }
}
