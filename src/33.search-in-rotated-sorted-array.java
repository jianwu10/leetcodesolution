/*
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.08%)
 * Total Accepted:    304.4K
 * Total Submissions: 949K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 */
class Solution {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int start = 0;
    int end = nums.length - 1;
    int baseline = nums[end];

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        if (target > baseline) {
          // target is in the upper part
          end = mid;
        }
        if (target <= baseline && nums[mid] <= baseline) {
          // target is in the lower part as well as nums[mid]
          end = mid;
        }
        if (target <= baseline && nums[mid] > baseline) {
          // target is in the lower part
          // nums[mid] is in the upper part
          start = mid;
        }
      } else {
        if (target <= baseline) {
          start = mid;
        }
        if (target > baseline && nums[mid] > baseline) {
          start = mid;
        }
        if (target > baseline && nums[mid] <= baseline) {
          end = mid;
        }
      }
    }

    if (nums[start] == target) {
      return start;
    }

    if (nums[end] == target) {
      return end;
    }

    return -1;
  }
}
