/*
 * [287] Find the Duplicate Number
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 * algorithms
 * Medium (46.05%)
 * Total Accepted:    133.3K
 * Total Submissions: 289.4K
 * Testcase Example:  '[1,3,4,2,2]'
 *
 * Given an array nums containing n + 1 integers where each integer is between
 * 1 and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 *
 * Note:
 *
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated
 * more than once.
 *
 *
 */
class Solution {
  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException();
    }

    int start = 1;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (count(nums, mid) > mid) {
        end = mid;
      } else {
        start = mid;
      }
    }
    if (count(nums, start) > start) {
      return start;
    }
    return end;
  }

  public int count(int[] arr, int target) {
    // count the number of elements <= target
    int result = 0;
    for (int element : arr) {
      if (element <= target) {
        result++;
      }
    }
    return result;
  }
}
