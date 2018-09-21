/*
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (34.77%)
 * Total Accepted:    136.2K
 * Total Submissions: 391.8K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 *
 * Example:
 *
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode partition(ListNode head, int x) {
    if (head == null) {
      return head;
    }

    ListNode dummyLeft = new ListNode(0);
    ListNode dummyRight = new ListNode(0);
    ListNode leftTail = dummyLeft;
    ListNode rightTail = dummyRight;

    while (head != null) {
      if (head.val < x) {
        leftTail.next = head;
        leftTail = head;
      } else {
        rightTail.next = head;
        rightTail = head;
      }
      head = head.next;
    }

    rightTail.next = null;
    leftTail.next = dummyRight.next;
    return dummyLeft.next;
  }
}
