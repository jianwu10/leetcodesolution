/*
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (49.84%)
 * Total Accepted:    159.6K
 * Total Submissions: 320.1K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 *
 *
 * Example 2:
 *
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 *
 *
 * Note:
 *
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 *
 *
 *
 */
class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0) {
      return new int[0];
    }
    if (nums2 == null || nums2.length == 0) {
      return new int[0];
    }

    boolean isNums1Longer = nums1.length > nums2.length ? true : false;
    Set<Integer> set = new HashSet<>();

    if (isNums1Longer) {
      Arrays.sort(nums2);
    } else {
      Arrays.sort(nums1);
    }

    if (isNums1Longer) {
      for (int element : nums1) {
        if (binarySearch(nums2, element)) {
          set.add(element);
        }
      }
    } else {
      for (int element : nums2) {
        if (binarySearch(nums1, element)) {
          set.add(element);
        }
      }
    }

    int[] result = new int[set.size()];
    int i = 0;
    for (int element : set) {
      result[i++] = element;
    }
    return result;
  }

  public boolean binarySearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == target) {
        return true;
      } else if (arr[mid] > target) {
        end = mid;
      } else {
        start = mid;
      }
    }

    if (arr[start] == target) {
      return true;
    }

    if (arr[end] == target) {
      return true;
    }

    return false;
  }
}
