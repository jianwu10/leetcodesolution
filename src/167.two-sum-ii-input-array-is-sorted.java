/*
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (47.61%)
 * Total Accepted:    171.8K
 * Total Submissions: 360.9K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 *
 *
 * Example:
 *
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 */
class Solution {
  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length < 2) {
      throw new IllegalArgumentException();
    }

    int[] result = new int[2];
    for (int i = 0; i < numbers.length; i++) {
      int index = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
      if (index != -1) {
        result[0] = i + 1;
        result[1] = index + 1;
        break;
      }
    }
    return result;
  }

  public int binarySearch(int[] arr, int start, int end, int target) {
    int low = start;
    int high = end;
    while (low + 1 < high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] > target) {
        high = mid;
      } else {
        low = mid;
      }
    }

    if (arr[low] == target) {
      return low;
    }

    if (arr[high] == target) {
      return high;
    }

    return -1;
  }
}
