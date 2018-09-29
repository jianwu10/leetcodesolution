/*
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (39.27%)
 * Total Accepted:    155.8K
 * Total Submissions: 396.7K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 *
 * Example:
 *
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4.
 *
 * Note:
 *
 *
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length.
 * Your algorithm should run in O(n2) complexity.
 *
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */
class Solution {
  // dynamic programming
  // public int lengthOfLIS(int[] nums) {
  //   // store the length of LIS from 0 to i
  //   int[] currentLIS = new int[nums.length];
  //   int max = 0;
  //
  //   for (int i = 0; i < nums.length; i++) {
  //     currentLIS[i] = 1;
  //     for (int j = 0; j < i; j++) {
  //       if (nums[i] > nums[j]) {
  //         currentLIS[i] = currentLIS[i] - currentLIS[j] > 1 ? currentLIS[i] : currentLIS[j] + 1;
  //       }
  //     }
  //
  //     if (currentLIS[i] > max) {
  //       max = currentLIS[i];
  //     }
  //   }
  //
  //   return max;
  // }

  // binary search
  public int lengthOfLIS(int[] nums) {
    int[] subsequence = new int[nums.length + 1];
    subsequence[0] = Integer.MIN_VALUE;
    for (int i = 1; i <= nums.length; i++) {
      subsequence[i] = Integer.MAX_VALUE;
    }

    for (int i = 0; i < nums.length; i++) {
      int index = binarySearch(subsequence, nums[i]);
      subsequence[index] = nums[i];
    }

    for (int i = nums.length; i >= 1; i--) {
      if (subsequence[i] != Integer.MAX_VALUE) {
        return i;
      }
    }

    return 0;
  }

  public int binarySearch(int[] arr, int target) {
    // find the first index that >= target
    int start = 0;
    int end = arr.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (arr[start] >= target) {
      return start;
    }
    
    return end;
  }
}
