/*
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (23.94%)
 * Total Accepted:    307.2K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 *
 * Example 2:
 *
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 *
 */
class Solution {
  // Binary Search on Results
  // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
  //   int n = nums1.length + nums2.length;
  //   if (n % 2 == 0) {
  //     return (findKth(nums1, nums2, n / 2) + findKth(nums1, nums2, n / 2 + 1)) / 2.0;
  //   } else {
  //     return findKth(nums1, nums2, n / 2 + 1);
  //   }
  // }
  //
  // // find the kth number in ascending order after merging two arrays
  // // k is non-zero based
  // // binary search on results
  // public int findKth(int[] nums1, int[] nums2, int k) {
  //   if (nums1.length == 0) {
  //     return nums2[k - 1];
  //   }
  //
  //   if (nums2.length == 0) {
  //     return nums1[k - 1];
  //   }
  //
  //   int start = Math.min(nums1[0], nums2[0]);
  //   int end = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
  //   // find the first number with count >= k
  //   while (start + 1 < end) {
  //     int mid = start + (end - start) / 2;
  //     if (countSmallerOrEqual(nums1, mid) + countSmallerOrEqual(nums2, mid) < k) {
  //       start = mid;
  //     } else {
  //       end = mid;
  //     }
  //   }
  //
  //   if (countSmallerOrEqual(nums1, start) + countSmallerOrEqual(nums2, start) >= k) {
  //     return start;
  //   } else {
  //     return end;
  //   }
  // }
  //
  // public int countSmallerOrEqual(int[] arr, int target) {
  //   // count the number of elements in arr that <= target
  //   // equivalent to find the first index that > target
  //   int start = 0;
  //   int end = arr.length - 1;
  //   while (start + 1 < end) {
  //     int mid = start + (end - start) / 2;
  //     if (arr[mid] <= target) {
  //       start = mid;
  //     } else {
  //       end = mid;
  //     }
  //   }
  //   if (arr[start] > target) {
  //     return start;
  //   }
  //
  //   if (arr[end] > target) {
  //     return end;
  //   }
  //
  //   if (arr[0] > target) {
  //     return 0;
  //   } else {
  //     return arr.length;
  //   }
  // }

  // Divide and Conquer
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length + nums2.length;
    if (n % 2 == 0) {
      return (findKth(nums1, 0, nums2, 0, n/2) + findKth(nums1, 0, nums2, 0, n/2 + 1)) / 2.0;
    } else {
      return findKth(nums1, 0, nums2, 0, n/2 + 1);
    }
  }

  public int findKth(int[] A, int startA, int[] B, int startB, int k) {
    if (startA >= A.length) {
      return B[startB + k - 1];
    }

    if (startB >= B.length) {
      return A[startA + k - 1];
    }

    if (k == 1) {
      return Math.min(A[startA], B[startB]);
    }

    int halfKA = startA + k/2 - 1 < A.length? A[startA + k/2 - 1]: Integer.MAX_VALUE;
    int halfKB = startB + k/2 - 1 < B.length? B[startB + k/2 - 1]: Integer.MAX_VALUE;

    if (halfKA < halfKB) {
      return findKth(A, startA + k/2, B, startB, k - k/2);
    } else {
      return findKth(A, startA, B, startB + k/2, k - k/2);
    }
  }
}
