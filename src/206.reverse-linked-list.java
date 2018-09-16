/*
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (49.24%)
 * Total Accepted:    410.8K
 * Total Submissions: 834.4K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 *
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
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
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    return reverseRecursive(head, prev);
  }

  public ListNode reverseRecursive(ListNode head, ListNode prev) {
    if (head == null) {
      return prev;
    }

    ListNode temp = head.next;
    head.next = prev;
    return reverseRecursive(temp, head);
  }

  public ListNode reverseListIterative(ListNode head) {
    ListNode prev = null;

    while (head != null) {
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }

    return prev;
  }
}
