/*
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (32.47%)
 * Total Accepted:    154.6K
 * Total Submissions: 476.2K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
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
  public ListNode reverseBetween(ListNode head, int m, int n) {
    int index = 1;
    ListNode resultHead = head;
    ListNode start = null;

    while (index < m) {
      index++;
      start = head;
      head = head.next;
    }

    ListNode end = head;
    ListNode prev = null;
    while (index <= n) {
      index++;
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }

    if (start != null) {
      start.next = prev;
    }

    if (end != null) {
      end.next = head;
    }

    if (m == 1) {
      resultHead = prev;
    };

    return resultHead;
  }
}
