/*
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (30.11%)
 * Total Accepted:    266.1K
 * Total Submissions: 883.6K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 *
 * Example:
 *
 *
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
      ListNode dummy = new ListNode(0);
      ListNode tail = dummy;
      if (lists == null || lists.length == 0) {
        return dummy.next;
      }
      // int k = lists.length;
      // Queue<ListNode> minHeap = new PriorityQueue<ListNode>(k, new Comparator<ListNode>() {
      //   public int compare(ListNode a, ListNode b) {
      //     return a.val - b.val;
      //   }
      // });
      //
      // for (int i = 0; i < k; i++) {
      //   if (lists[i] != null) {
      //     minHeap.offer(lists[i]);
      //   }
      // }
      //
      // while (!minHeap.isEmpty()) {
      //   ListNode minNode = minHeap.poll();
      //   tail.next = minNode;
      //   tail = minNode;
      //   if (minNode.next != null) {
      //     minHeap.offer(minNode.next);
      //   }
      // }
      //
      // return dummy.next;

      return helper(lists, 0, lists.length - 1);
    }

    public ListNode helper(ListNode[] lists, int start, int end) {
      if (start == end) {
        return lists[start];
      }

      int mid = start + (end - start) / 2;
      ListNode left = helper(lists, start, mid);
      ListNode right = helper(lists, mid + 1, end);
      return mergeTwoSortedLists(left, right);
    }

    public ListNode mergeTwoSortedLists(ListNode A, ListNode B) {
      ListNode head = new ListNode(0);
      ListNode tail = head;

      while (A != null && B != null) {
        if (A.val < B.val) {
          tail.next = A;
          tail = A;
          A = A.next;
        } else {
          tail.next = B;
          tail = B;
          B = B.next;
        }
      }

      if (A != null) {
        tail.next = A;
      }

      if (B != null) {
        tail.next = B;
      }

      return head.next;
    }
}
